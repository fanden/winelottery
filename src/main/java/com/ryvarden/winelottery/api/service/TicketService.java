package com.ryvarden.winelottery.api.service;
import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.Ticket;
import com.ryvarden.winelottery.api.model.User;
import com.ryvarden.winelottery.api.service.interfaces.ILotteryService;
import com.ryvarden.winelottery.api.service.interfaces.ITicketService;
import com.ryvarden.winelottery.api.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService {
    private final ILotteryService lotteryService;
    private final IUserService userService;
    private List<Ticket> ticketList;

    @Autowired
    public TicketService(ILotteryService lotteryService, IUserService userService) {
        this.lotteryService = lotteryService;
        this.userService = userService;
        this.ticketList = new ArrayList<Ticket>();
    }

    @Override
    public void purchaseTicket(int lotteryId, int userId, List<Integer> ticketNumbersToPurchase) {
        // userId and tickerNumber needs to be 1 or above
        Lottery lottery = lotteryService.getLotteryById(lotteryId)
                .orElseThrow();
        User user = userService.getUserById(lottery, userId);
    }

    @Override
    public Optional<List<Ticket>> getTicketsForUser(int lotteryId, int userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Ticket>> getTicketsForLottery(int lotteryId) {
        return Optional.empty();
    }

    @Override
    public Optional<Ticket> getTicketForNumber(int lotteryId, int ticketNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getAvailableTicketsForLottery(int lotteryId) {
        return Optional.empty();
    }
}
