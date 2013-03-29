package org.motechproject.tama.reports.domain.repository;

import org.motechproject.tama.reports.domain.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllMessages extends JpaRepository<Messages, Long> {
}
