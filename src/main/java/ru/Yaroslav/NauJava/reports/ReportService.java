package ru.Yaroslav.NauJava.reports;

public interface ReportService {

    /**
     * Создает новый отчет
     */
    Long createReport();

    /**
     * Асинхронно генерирует отчет
     */
    void generateReportAsync(Long reportId);

    /**
     * Возвращает содержимое отчета
     */
    String getReportContent(Long id);
}