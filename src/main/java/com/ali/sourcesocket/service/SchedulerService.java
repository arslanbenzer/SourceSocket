package com.ali.sourcesocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Component
public class SchedulerService {

    @Autowired
    private GeneratorService generatorService;

    @Scheduled(fixedRate = 200)
    public void generate() throws IOException, NoSuchAlgorithmException {
        generatorService.generateNumber();
    }
}
