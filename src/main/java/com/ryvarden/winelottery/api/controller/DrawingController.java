package com.ryvarden.winelottery.api.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/drawings/")
// Versioning is important for future compatability, in case changes are needed to the API
public class DrawingController {

    // TODO @PostMapping("/draw/{lotteryId}")
    // Sette status på lotteriet til done
    // Du kan ikke trekke to ganger, hvis du prøver igjen og den ikke er active får du en error

    // TODO @GetMapping("/results/{lotteryId}")
    // Kan kalles så mange ganer du vil for å lese ut resultatene

}
