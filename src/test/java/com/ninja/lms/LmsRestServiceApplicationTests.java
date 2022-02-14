package com.ninja.lms;

import com.ninja.lms.controller.LMSBatchController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LmsRestServiceApplicationTests {

    @Autowired
    LMSBatchController batchController;

    @Test
    void contextLoads() {
        assertThat(batchController).isNotNull();
    }


}
