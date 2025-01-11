package com.ryvarden.winelottery.api.model;

public class Wine {
    private int id;
    private String name;
    private int price;
    private int lotteryId;
    private int winningTicketNumber;
    private int winningUserId;

    public Wine(int id, String name, int price, int lotteryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.lotteryId = lotteryId;
        this.winningTicketNumber = -1;
        this.winningUserId = -1;
    }

    public int getWinningTicketNumber() {
        return winningTicketNumber;
    }

    public void setWinningTicketNumber(int winningTicketNumber) {
        this.winningTicketNumber = winningTicketNumber;
    }

    public int getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(int lotteryId) {
        this.lotteryId = lotteryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getWinningUserId() {
        return winningUserId;
    }

    public void setWinningUserId(int winningUserId) {
        this.winningUserId = winningUserId;
    }

}
