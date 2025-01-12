package com.ryvarden.winelottery.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    private int id;
    private int ticketPriceInNOK;
    private int maxTickets;
    private List<Wine> wineList;
    // TODO impliment Fill with tickets in constructor
    private List<Ticket> ticketList;

    private String status;

    public Lottery(int id) {
        this.id = id;
        this.ticketPriceInNOK = 10;
        this.maxTickets = 100;
        this.wineList = new ArrayList<>();
        /* TODO ta denne i bruk
         *  Valid statuses: ACTIVE, CLOSED and INPROGRESS. Should be made into en enum in the future
         *  You won't be allowed to purchaces tickets if the lottery in progress or closed*/
        this.status = "ACTIVE";
        this.ticketList = initializeTicketList(this.maxTickets, id);
    }

    public Lottery(int id, int ticketPriceInNOK, int maxTickets) {
        this.id = id;
        this.ticketPriceInNOK = ticketPriceInNOK;
        this.maxTickets = maxTickets;
        this.wineList = new ArrayList<>();
        /* TODO Impliment this value
         *  Valid statuses: ACTIVE, CLOSED and INPROGRESS. Should be made into en enum in the future
         *  You won't be allowed to purchaces tickets if the lottery in progress or closed*/
        this.status = "ACTIVE";
        this.ticketList = initializeTicketList(this.maxTickets, id);
    }

    private List<Ticket> initializeTicketList(int maxTickets, int lotteryId) {
        return IntStream.rangeClosed(1, maxTickets)
                .mapToObj(id -> new Ticket(id, lotteryId))
                .collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketPriceInNOK() {
        return ticketPriceInNOK;
    }

    public void setTicketPriceInNOK(int ticketPriceInNOK) {
        this.ticketPriceInNOK = ticketPriceInNOK;
    }

    public int getMaxTicketsTickets() {
        return maxTickets;
    }

    public void setMaxTickets(int maxTickets) {
        this.maxTickets = maxTickets;
    }

    public List<Wine> getWineList() {
        return wineList;
    }

    public void setWineList(List<Wine> wineList) {
        this.wineList = wineList;
    }

    public void addWine(List<Wine> wine){
        wine.forEach(w -> wineList.addLast(w));
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Ticket> getTicketList(){
        return this.ticketList;
    }

}
