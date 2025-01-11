package com.ryvarden.winelottery.api.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Ticket> ticketList;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.ticketList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void addTicket(Ticket ticket){
        ticketList.add(ticket);
    }


}
