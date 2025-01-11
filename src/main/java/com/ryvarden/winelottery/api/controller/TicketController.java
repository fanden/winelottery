package com.ryvarden.winelottery.api.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets")
// Versioning is important for future compatability, in case changes are needed to the API
public class TicketController {
    // @PostMapping("/purchase")
    // @GetMapping("/user/{lotteryId}/{userId}")
    // @GetMapping("/lottery/{lotteryId}")
    // @GetMapping("/number/{lotteryId}/{number}")
}
