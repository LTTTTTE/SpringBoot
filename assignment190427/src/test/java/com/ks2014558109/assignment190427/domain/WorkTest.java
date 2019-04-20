package com.ks2014558109.assignment190427.domain;

import com.ks2014558109.assignment190427.repository.WorkRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkTest {

    @Autowired
    WorkRepository workRepository;
    Work savedWork;

    @Before
    public void workWriteTest(){


        savedWork = workRepository.save(Work.builder()
                .company("(주)홍길동")
                .position("개발자")
                .webSite("http://www.company.domain")
                .startDate(LocalDate.of(2019,01,01))
                .endDate(LocalDate.of(2019,01,02))
                .summary("요약...")
                .build()
        );
    }

    @Test
    public void workReadTest(){
        assertThat(savedWork)
                .isEqualTo(workRepository.findById(savedWork.getIdx()).orElse(null));
    }
}
