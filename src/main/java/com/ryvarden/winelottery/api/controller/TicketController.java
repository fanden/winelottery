package com.ryvarden.winelottery.api.controller;
import com.ryvarden.winelottery.api.service.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
// Versioning is important for future compatability, in case changes are needed to the API
public class TicketController {

    private final ITicketService ticketService;

    @Autowired
    public TicketController(ITicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/reserve/{lotteryId}/{userId}")
    public ResponseEntity<?> reserveTicket(@PathVariable int lotteryId, @PathVariable int userId, @RequestBody List<Integer> ticketNumbersToReserve){
        boolean reserved = ticketService.reserveTicket(lotteryId, userId, ticketNumbersToReserve);

        if(reserved){
            return ResponseEntity.ok("Tickets reserved successfully");
        } else{
            // This needs to be expanded to include other types of errors. Right now it only signals success/fail and not what type of error occurred
            return ResponseEntity.badRequest().build();
        }
    }


    // TODO Impliment ticketService.purchaseTicket()
    @PostMapping("/purchase/{lotteryId}/{userId}")
    public ResponseEntity<?> purchaseTicket(@PathVariable int lotteryId, @PathVariable int userId, @RequestBody List<Integer> ticketNumbersToReserve){
        boolean purchased = ticketService.purchaseTicket(lotteryId, userId, ticketNumbersToReserve);

        if(purchased){
            return ResponseEntity.ok("Tickets purchased successfully");
        } else{
            // This needs to be expanded to include other types of errors. Right now it only signals success/fail and not what type of error occurred
            return ResponseEntity.badRequest().build();
        }
    }

    // TODO @GetMapping("/number/{lotteryId}/{number}")

    // TODO Get avalible
    // TODO Get reserved
    // TODO Get purchased

    // Skal disse implimenteres her
    // TODO @GetMapping("/user/{lotteryId}/{userId}")
    // TODO @GetMapping("/lottery/{lotteryId}")



}
