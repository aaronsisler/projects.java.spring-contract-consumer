package com.ebsolutions.spring_cdc.consumer.controller;

import com.ebsolutions.spring_cdc.consumer.config.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestContractController {
    @Autowired
    private ProducerConfig producerConfig;

    @GetMapping()
    public ResponseEntity<String> callProducerApplication() {

        return ResponseEntity.status((200)).body(producerConfig.getUrl() + ":" + producerConfig.getPort());
    }
}
