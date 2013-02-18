package org.motechproject.tama.reports.domain.repository;

import org.junit.Test;
import org.motechproject.tama.reports.domain.HealthTips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import static junit.framework.Assert.assertNotNull;

public class AllHealthTipsIT extends AbstractRepositoryTest {

    @Autowired
    private AllHealthTips allHealthTips;

    @Test
    public void shouldSaveHealthTips() {
        HealthTips healthTips = new HealthTips();
        allHealthTips.save(healthTips);
        assertNotNull(healthTips.getId());
    }

    @Override
    protected JpaRepository getRepository() {
        return allHealthTips;
    }
}
