package com.ryvarden.winelottery.api.service.interfaces;

import com.ryvarden.winelottery.api.model.Lottery;
import java.util.Optional;

public interface ILotteryService {
    void createLottery();
    Optional<Lottery> getCurrentLottery();
    Optional<Lottery> getLotteryById(int lotteryId);
}
