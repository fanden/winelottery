package com.ryvarden.winelottery.api.service.interfaces;

import com.ryvarden.winelottery.api.model.Wine;

import java.util.List;

public interface IDrawingService {
    void drawLottery(int lotteryId);
    List<Wine> getResults(int lotteryId);
}
