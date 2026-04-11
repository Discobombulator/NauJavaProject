package ru.Yaroslav.NauJava.reports;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.Yaroslav.NauJava.dateBase.entity.FoodEntry;
import ru.Yaroslav.NauJava.dateBase.repository.FoodEntryRepository;
import ru.Yaroslav.NauJava.dateBase.repository.UserRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Реализация сервиса отчетов
 */
@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final FoodEntryRepository foodEntryRepository;

    /**
     * Конструктор с внедрением зависимостей
     */
    public ReportServiceImpl(ReportRepository reportRepository,
                             UserRepository userRepository,
                             FoodEntryRepository foodEntryRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.foodEntryRepository = foodEntryRepository;
    }

    /**
     * Создает новый отчет
     */
    @Override
    public Long createReport() {
        Report report = new Report(ReportStatus.CREATED);
        reportRepository.save(report);
        return report.getId();
    }

    /**
     * Асинхронно генерирует отчет в отдельных потоках
     */
    @Override
    @Async
    public void generateReportAsync(Long reportId) {
        CompletableFuture.runAsync(() -> {
            Report report = reportRepository.findById(reportId).orElseThrow();

            long totalStart = System.currentTimeMillis();

            try {
                // ---------- Поток 1 (пользователи)
                final long[] userTime = new long[1];
                final long[] userCount = new long[1];

                Thread userThread = new Thread(() -> {
                    long start = System.currentTimeMillis();
                    userCount[0] = userRepository.count();
                    userTime[0] = System.currentTimeMillis() - start;
                });

                // ---------- Поток 2 (FoodEntry)
                final long[] listTime = new long[1];
                final List<FoodEntry>[] entries = new List[1];

                Thread listThread = new Thread(() -> {
                    long start = System.currentTimeMillis();
                    entries[0] = (List<FoodEntry>) foodEntryRepository.findAll();
                    listTime[0] = System.currentTimeMillis() - start;
                });

                userThread.start();
                listThread.start();

                userThread.join();
                listThread.join();

                long totalTime = System.currentTimeMillis() - totalStart;

                // ---------- HTML
                String html = buildHtmlReport(
                        userCount[0],
                        entries[0],
                        userTime[0],
                        listTime[0],
                        totalTime
                );

                report.setContent(html);
                report.setStatus(ReportStatus.COMPLETED);

            } catch (Exception e) {
                report.setStatus(ReportStatus.ERROR);
                report.setContent("Ошибка при формировании отчета: " + e.getMessage());
            }

            reportRepository.save(report);
        });
    }

    /**
     * Возвращает содержимое отчета по идентификатору
     */
    @Override
    public String getReportContent(Long id) {
        Report report = reportRepository.findById(id).orElseThrow();

        if (report.getStatus() == ReportStatus.CREATED) {
            return "Отчет еще формируется";
        }

        if (report.getStatus() == ReportStatus.ERROR) {
            return "Ошибка при формировании отчета";
        }

        return report.getContent();
    }

    /**
     * Формирует HTML-отчет на основе собранных данных
     */
    private String buildHtmlReport(long userCount,
                                   List<FoodEntry> entries,
                                   long userTime,
                                   long listTime,
                                   long totalTime) {

        StringBuilder html = new StringBuilder();

        html.append("<html><body>");
        html.append("<h1>Отчет</h1>");

        html.append("<h2>Количество пользователей: ").append(userCount).append("</h2>");
        html.append("<p>Время: ").append(userTime).append(" ms</p>");

        html.append("<h2>Список FoodEntry</h2>");
        html.append("<p>Время: ").append(listTime).append(" ms</p>");

        html.append("<table border='1'>");
        html.append("<tr><th>ID</th><th>Дата</th></tr>");

        for (FoodEntry entry : entries) {
            html.append("<tr>")
                    .append("<td>").append(entry.getId()).append("</td>")
                    .append("<td>").append(entry.getId()).append("</td>")
                    .append("</tr>");
        }

        html.append("</table>");

        html.append("<h3>Общее время: ").append(totalTime).append(" ms</h3>");

        html.append("</body></html>");

        return html.toString();
    }
}