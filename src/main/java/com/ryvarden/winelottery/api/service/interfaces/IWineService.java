package com.ryvarden.winelottery.api.service.interfaces;

import com.ryvarden.winelottery.api.model.Wine;

import java.util.List;
import java.util.Optional;

public interface IWineService {
    boolean addWine(int lotteryId, List<Wine> wineList);
    Optional<List<Wine>> getWineList(int lotteryId);

}
