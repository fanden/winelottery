package com.ryvarden.winelottery.api.service;
import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.Wine;
import com.ryvarden.winelottery.api.service.interfaces.ILotteryService;
import com.ryvarden.winelottery.api.service.interfaces.IUserService;
import com.ryvarden.winelottery.api.service.interfaces.IWineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineService implements IWineService {
    private final ILotteryService lotteryService;

    @Autowired
    public WineService(ILotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }


    @Override
    public boolean addWine(int lotteryId, List<Wine> wineList) {
        return lotteryService.getLotteryById(lotteryId)
                .map(lottery -> {
                    lottery.addWine(wineList);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public Optional<List<Wine>> getWineList(int lotteryId) {
        return lotteryService.getLotteryById(lotteryId)
                .map(Lottery::getWineList);
    }
}
