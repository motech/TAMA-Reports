package org.motechproject.tama.reports.domain.service;

import org.motechproject.tama.reports.domain.HealthTips;
import org.motechproject.tama.reports.domain.repository.AllHealthTips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HealthTipsService {

    private AllHealthTips allHealthTips;

    @Autowired
    public HealthTipsService(AllHealthTips allHealthTips) {
        this.allHealthTips = allHealthTips;
    }

    public void save(HealthTips healthTips) {
        allHealthTips.save(healthTips);
    }
}
