package ru.Yaroslav.NauJava.reports;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью Report
 */
public interface ReportRepository extends JpaRepository<Report, Long> {
}