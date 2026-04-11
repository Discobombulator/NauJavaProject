package ru.Yaroslav.NauJava.reports;

import jakarta.persistence.*;

/**
 * Сущность отчета
 */
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    @Column(columnDefinition = "TEXT")
    private String content;

    /**
     * Конструктор по умолчанию
     */
    public Report() {}

    /**
     * Конструктор с указанием статуса
     */
    public Report(ReportStatus status) {
        this.status = status;
    }

    /**
     * Возвращает идентификатор отчета
     */
    public Long getId() {
        return id;
    }

    /**
     * Возвращает статус отчета
     */
    public ReportStatus getStatus() {
        return status;
    }

    /**
     * Устанавливает статус отчета
     */
    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    /**
     * Возвращает содержимое отчета
     */
    public String getContent() {
        return content;
    }

    /**
     * Устанавливает содержимое отчета
     */
    public void setContent(String content) {
        this.content = content;
    }
}