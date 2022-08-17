package br.com.cwi.AumigoEstouAqui.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeNowService {
    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }
}
