package ru.Yaroslav.NauJava.reports;

import org.springframework.web.bind.annotation.*;

/**
 * REST-контроллер для управления отчетами
 */
@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    /**
     * Конструктор с внедрением зависимости
     */
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * Создает отчет и запускает его асинхронную генерацию
     */
    @PostMapping
    public Long createReport() {
        Long id = reportService.createReport();
        reportService.generateReportAsync(id);
        return id;
    }

    /**
     * Возвращает содержимое отчета по идентификатору
     */
    @GetMapping("/{id}")
    public String getReport(@PathVariable Long id) {
        return reportService.getReportContent(id);
    }
}