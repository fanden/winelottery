package com.ryvarden.winelottery.api.service;
import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.Ticket;
import com.ryvarden.winelottery.api.model.User;
import com.ryvarden.winelottery.api.service.interfaces.ILotteryService;
import com.ryvarden.winelottery.api.service.interfaces.ITicketService;
import com.ryvarden.winelottery.api.service.interfaces.IUserService;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // TODO Implement method
    @Override
    public void purchaseTicket(int lotteryId, int userId, List<Integer> ticketNumbersToPurchase) {
        User user = userService.getUserById(lotteryId, userId);

    }

    // TODO Implement method
    @Override
    public Optional<List<Ticket>> getTicketsForUser(int lotteryId, int userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Ticket>> getTicketsForLottery(int lotteryId) {
        return lotteryService.getLotteryById(lotteryId)
                .map(Lottery::getTicketList);
    }

    @Override
    public Optional<Ticket> getTicketForNumber(int lotteryId, int ticketNumber) {
        return lotteryService.getLotteryById(lotteryId)
                .flatMap(lottery -> lottery.getTicketList().stream()
                        .filter(ticket -> ticket.getNumber() == ticketNumber)
                        .findFirst());
    }

    @Override
    public Optional<List<Ticket>> getAvailableTicketsForLottery(int lotteryId) {
        return lotteryService.getLotteryById(lotteryId)
                .map(lottery -> lottery.getTicketList().stream()
                        .filter(ticket -> "AVAILABLE".equals(ticket.getStatus()))
                        .collect(Collectors.toList())
                );
    }
}
