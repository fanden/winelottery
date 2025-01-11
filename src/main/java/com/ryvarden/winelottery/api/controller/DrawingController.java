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
    //@PostMapping("/draw/{lotteryId}")

    //@GetMapping("/results/{lotteryId}")
}
