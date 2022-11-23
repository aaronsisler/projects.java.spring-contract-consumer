package com.ebsolutions.spring_cdc.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"com.ebsolutions:spring-contract-producer:+:stubs:8300"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ConsumerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnEvenMessage() throws Exception {
        this.mockMvc.perform(
                        get("/test-contract/even-odd?number=2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Even")));
    }

    @Test
    public void shouldReturnOddMessage() throws Exception {
        this.mockMvc.perform(
                        get("/test-contract/even-odd?number=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Odd")));
    }
}
