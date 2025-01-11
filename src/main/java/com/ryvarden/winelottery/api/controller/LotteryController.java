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

    @GetMapping("/wines/{lotteryId}")
    public ResponseEntity<?> getWineList(@PathVariable int lotteryId) {
        Optional<List<Wine>> wineList = lotteryService.getWineList(lotteryId);

        return wineList
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/wines/add/{lotteryId}")
    public ResponseEntity<?> addWine(@PathVariable int lotteryId, @RequestBody List<Wine> wineList){
        Optional<Lottery> lottery = lotteryService.addWine(lotteryId, wineList);

        return lottery
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
