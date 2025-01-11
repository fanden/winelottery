package com.ryvarden.winelottery.api.service;
import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.User;
import com.ryvarden.winelottery.api.model.Wine;
import com.ryvarden.winelottery.api.service.interfaces.ILotteryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LotteryService implements ILotteryService {

    private List<Lottery> lotteryList;
    private int lotteryCount;

    public LotteryService(){
        this.lotteryList = new ArrayList<>();
        this.lotteryCount = 0;
    }

    @Override
    public void createLottery() {
        lotteryList.add(new Lottery(lotteryCount));
        lotteryCount++;
    }

    @Override
    public Optional<Lottery> getCurrentLottery() {
        if (lotteryList.isEmpty()) {
            return Optional.empty();
        }
        // The latest lottery should be the last one inserted
        return Optional.of(lotteryList.getLast());
    }

    @Override
    public Optional<Lottery> getLotteryById(int lotteryId) {
        return lotteryList.stream()
                .filter(lottery -> lottery.getId() == lotteryId)
                .findFirst();
    }

    @Override
    public Optional<List<Wine>> getWineList(int lotteryId) {

        return lotteryList.stream()
                .filter(lottery -> lottery.getId() == lotteryId)
                .findFirst()
                .map(Lottery::getWineList);
    }

    @Override
    public Optional<Lottery> addWine(int lotteryId, List<Wine> wineList) {
        return lotteryList.stream()
                .filter(lottery -> lottery.getId() == lotteryId)
                .findFirst()
                .map(lottery -> {
                    lottery.addWine(wineList);
                    return lottery;
                });
    }
}
