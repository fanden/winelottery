package com.ryvarden.winelottery.api.service.interfaces;

import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.Wine;

import java.util.List;
import java.util.Optional;

public interface ILotteryService {
    void createLottery();
    Optional<Lottery> getCurrentLottery();
    Optional<Lottery> getLotteryById(int lotteryId);
}
