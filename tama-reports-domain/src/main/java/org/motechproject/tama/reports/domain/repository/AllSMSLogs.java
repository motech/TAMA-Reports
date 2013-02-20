package org.motechproject.tama.reports.domain.repository;

import org.motechproject.tama.reports.domain.SMSLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllSMSLogs extends JpaRepository<SMSLog, Long> {
}
