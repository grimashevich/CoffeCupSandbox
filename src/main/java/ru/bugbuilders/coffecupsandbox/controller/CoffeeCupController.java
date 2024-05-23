package ru.bugbuilders.coffecupsandbox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bugbuilders.coffecupsandbox.model.Answer;
import ru.bugbuilders.coffecupsandbox.service.CoffeeCupService;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
public class CoffeeCupController {

    private final CoffeeCupService coffeeCupService;

    @GetMapping(value = "/coffee-cup")
    public ResponseEntity<Answer> getCoffeeCup() throws InterruptedException {
        logTime("start");
        Answer answer = new Answer();
        answer.setRequestTime(Instant.now());
        answer.setId(coffeeCupService.getCoffeeCup());
        answer.setServiceAnswerTime(Instant.now());
        logTime("end");
        return ResponseEntity.ok(answer);
    }

    public void logTime(String msg) {
        Logger logger = Logger.getLogger("CoffeeCupLogger");
        logger.info(Instant.now().atZone(ZoneId.of("Europe/Moscow")).toLocalDateTime().toString() + " " + msg);
    }
}
