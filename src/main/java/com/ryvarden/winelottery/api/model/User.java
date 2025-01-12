package com.ryvarden.winelottery.api.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String phone;
    // Flytt denne til Lottery klassen, ikke ha den to steder. Gir mer mening å ha det under Lottery
    private List<Ticket> ticketList;

    public User(int id, String name, String phone) {
        // Id skal gå i stigende rekkefølge fra 0 og oppgover
        this.id = id;
        this.name = name;
        this.phone = phone;
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
