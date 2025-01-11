package com.ryvarden.winelottery.api.service.interfaces;

import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.Wine;

import java.util.List;
import java.util.Optional;

public interface ILotteryService {
    void createLottery();
    Optional<Lottery> getCurrentLottery();
    Optional<Lottery> getLotteryById(int lotteryId);
    Optional<List<Wine>> getWineList(int lotteryId);
    Optional<Lottery> addWine(int lotteryId, List<Wine> wineList);
}
