package com.ebsolutions.spring_cdc.consumer.controller;

import com.ebsolutions.spring_cdc.consumer.config.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("test-contract")
public class TestContractController {
    @Autowired
    private ProducerConfig producerConfig;

    @GetMapping()
    public ResponseEntity<String> callProducerApplication() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        String producerUri = "http://" + producerConfig.getHost() + ":" + producerConfig.getPort() + "/hello";
        URI uri = new URI(producerUri);
        String producerResponse = restTemplate.getForObject(uri, String.class);

        return ResponseEntity.status((200)).body(producerResponse);
    }
}
