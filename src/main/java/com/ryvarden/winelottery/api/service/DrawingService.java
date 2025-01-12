package com.ryvarden.winelottery.api.service;
import com.ryvarden.winelottery.api.model.Wine;
import com.ryvarden.winelottery.api.service.interfaces.IDrawingService;
import com.ryvarden.winelottery.api.service.interfaces.ILotteryService;
import com.ryvarden.winelottery.api.service.interfaces.ITicketService;
import com.ryvarden.winelottery.api.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrawingService implements IDrawingService {
    private final ILotteryService lotteryService;
    private final IUserService userService;
    private final ITicketService ticketService;

    @Autowired
    public DrawingService(ILotteryService lotteryService, IUserService userService, ITicketService ticketService){
        this.lotteryService = lotteryService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    /*TODO Impliment method
    *  Should only accept lotteries that are active
    *  When starting the drawing process, lotteries should be set to staus "INPROGRESS"*/
    @Override
    public void drawLottery(int lotteryId) {

    }

    /* TODO Impliment method
    *   Gets the winners for any given closed lottery*/
    @Override
    public List<Wine> getResults(int lotteryId) {
        return List.of();
    }
}
