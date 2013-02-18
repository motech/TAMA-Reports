package org.motechproject.tama.reports.domain.repository;

import org.motechproject.tama.reports.domain.HealthTips;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllHealthTips extends JpaRepository<HealthTips, Long> {
}
