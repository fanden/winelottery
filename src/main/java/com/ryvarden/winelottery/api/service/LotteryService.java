package com.ryvarden.winelottery.api.service;
import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.User;
import com.ryvarden.winelottery.api.model.Wine;
import com.ryvarden.winelottery.api.service.interfaces.ILotteryService;
import org.springframework.stereotype.Service;

import java.util.*;

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
        return lotteryList.stream()
                .filter(lottery -> "ACTIVE".equals(lottery.getStatus()))
                .max(Comparator.comparingInt(Lottery::getId));
    }

    @Override
    public Optional<Lottery> getLotteryById(int lotteryId) {
        return lotteryList.stream()
                .filter(lottery -> lottery.getId() == lotteryId)
                .findFirst();
    }


    // TODO Get avalible tickets

    // TODO Get unavalible tickets (purchased)

    // TODO Get unavalible tickets (reserved)

}
