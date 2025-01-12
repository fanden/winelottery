package com.ryvarden.winelottery.api.model;

public class Ticket {
    private int number;
    private int lotteryId;
    private String status;
    private int userId;

    public Ticket(int number, int lotteryId) {
        this.userId = -1;
        this.status = "AVAILABLE";
        this.lotteryId = lotteryId;
        this.number = number;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLotteryId() {
        return lotteryId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
