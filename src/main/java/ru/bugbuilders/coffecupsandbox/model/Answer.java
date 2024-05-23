package ru.bugbuilders.coffecupsandbox.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Answer {
    private int id;
    private Instant requestTime;
    private Instant serviceAnswerTime;
}
