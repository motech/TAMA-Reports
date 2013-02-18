package org.motechproject.tama.reports.domain.repository;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationPersistenceContext.xml")
public abstract class AbstractRepositoryTest {

    protected abstract JpaRepository getRepository();

    @After
    public void tearDown() {
        JpaRepository repository = getRepository();
        repository.flush();
        repository.deleteAll();
    }
}
