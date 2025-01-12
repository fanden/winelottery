package com.ryvarden.winelottery.api.controller;
import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.Ticket;
import com.ryvarden.winelottery.api.model.Wine;
import com.ryvarden.winelottery.api.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lotteries/")
// Versioning is important for future compatability, in case changes are needed to the API
public class LotteryController {

    private final LotteryService lotteryService;

    @Autowired
    public LotteryController(LotteryService lotteryService){
        this.lotteryService = lotteryService;
    }

    @PostMapping("/create")
    public void createLottery(){
        lotteryService.createLottery();
    }

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentLottery() {
        Optional<Lottery> lottery = lotteryService.getCurrentLottery();

        return lottery
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // TODO Move this to winecontroller

}
