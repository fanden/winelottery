package com.ryvarden.winelottery.api.model;

import java.util.ArrayList;
import java.util.List;

public class Lottery {
    private int id;
    private int ticketPriceInNOK;
    private int maxTickets;
    private List<Wine> wineList;

    public Lottery(int id) {
        this.id = id;
        this.ticketPriceInNOK = 10;
        this.maxTickets = 100;
        this.wineList = new ArrayList<>();
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

}
