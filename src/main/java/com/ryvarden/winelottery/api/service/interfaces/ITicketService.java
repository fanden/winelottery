package com.ryvarden.winelottery.api.service.interfaces;

import com.ryvarden.winelottery.api.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface ITicketService {
    boolean reserveTicket(int lotteryId, int userId, List<Integer> ticketNumbersToPurchase);
    boolean purchaseTicket(int lotteryId, int userId, List<Integer> ticketNumbersToPurchase);
    Optional<List<Ticket>> getTicketsForUser(int lotteryId, int userId);
    Optional<List<Ticket>> getTicketsForLottery(int lotteryId);
    Optional<Ticket> getTicketForNumber(int lotteryId, int ticketNumber);
    Optional<List<Ticket>> getAvailableTicketsForLottery(int lotteryId);

}
