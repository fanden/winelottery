package com.ryvarden.winelottery.api.controller;
import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.Wine;
import com.ryvarden.winelottery.api.service.WineService;
import com.ryvarden.winelottery.api.service.interfaces.IWineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/wines")
// Versioning is important for future compatability, in case changes are needed to the API
public class WineController {

    private final IWineService wineService;

    @Autowired
    public WineController(IWineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/{lotteryId}")
    public ResponseEntity<?> getWineList(@PathVariable int lotteryId) {
        Optional<List<Wine>> wineList = wineService.getWineList(lotteryId);

        return wineList
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add/{lotteryId}")
    public ResponseEntity<?> addWine(@PathVariable int lotteryId, @RequestBody List<Wine> wineList){
        boolean added = wineService.addWine(lotteryId, wineList);

        if (added){
            return ResponseEntity.ok("Wines added successfully");
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    // TODO @PutMapping("/update")
    /* TODO This should return a warning if the total price is over a certain threshold (default 1000 NOK)
        @PostMapping("/wines/add/{lotteryId}") */
}
