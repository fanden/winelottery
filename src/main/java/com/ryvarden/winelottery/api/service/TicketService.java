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

    @Autowired
    public TicketService(ILotteryService lotteryService, IUserService userService) {
        this.lotteryService = lotteryService;
        this.userService = userService;
    }

    @Override
    public boolean reserveTicket(int lotteryId, int userId, List<Integer> ticketNumbersToReserve) {

        if (lotteryId <= 0 || userId <= 0)
        {return false;}

        Optional<Lottery> lotteryOptional = lotteryService.getLotteryById(lotteryId);
        Optional<User> userOptional = userService.getUserById(userId);

        if(lotteryOptional.isEmpty() || userOptional.isEmpty())
        {return false;}

        Lottery lottery = lotteryOptional.get();
        User user = userOptional.get();

        if (!checkTicketListStatus(lottery, ticketNumbersToReserve))
        {return false;}

        updateTicketStatus(lottery, user, ticketNumbersToReserve, "RESERVED" );

        return true;
    }

    // TODO Implement method
    @Override
    public boolean purchaseTicket(int lotteryId, int userId, List<Integer> ticketNumbersToPurchase) {
        return true;
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

    private void updateTicketStatus(Lottery lottery, User user,List<Integer> ticketNumbersToUpdate, String status){
        ticketNumbersToUpdate.forEach(numberToReserve -> {
            Ticket ticket = lottery.getTicketList().stream()
                    .filter(tick -> tick.getNumber() == numberToReserve)
                    .findFirst()
                    .orElseThrow();
            ticket.setStatus(status);
            ticket.setUserId(user.getId());
        });
    }

    private boolean checkTicketListStatus(Lottery lottery, List<Integer> ticketNumbersToCheck){
        return ticketNumbersToCheck.stream()
                .allMatch(number -> lottery.getTicketList().stream()
                        .anyMatch(ticket -> ticket.getNumber() == number && "AVAILABLE".equals(ticket.getStatus())));
    }

}
