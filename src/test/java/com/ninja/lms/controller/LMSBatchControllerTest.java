package com.ninja.lms.controller;

import com.ninja.lms.entity.LMSBatch;
import com.ninja.lms.entity.LMSProgram;
import com.ninja.lms.service.LMSBatchService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebMvcTest(LMSBatchController.class)
@ExtendWith(SpringExtension.class)
@WithMockUser
public class LMSBatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LMSBatchService batchService;

    @Test
    public void shouldReturnUpMessage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/health"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("up")));
    }

    @Test
    public void givenBatches_whenGetBatches_thenReturnJsonArray() throws Exception {
        LMSProgram program = new LMSProgram(1, "Name", "Description", "Status", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), new ArrayList<>());
        LMSBatch batch = new LMSBatch(100, "Name", "Description", "Status", 10, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), program, 1);

        List<LMSBatch> allBatches = Arrays.asList(batch);

        BDDMockito.given(batchService.getAllBatches()).willReturn(allBatches);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/batches")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].batchName", Matchers.is(batch.getBatchName())));

    }

}
