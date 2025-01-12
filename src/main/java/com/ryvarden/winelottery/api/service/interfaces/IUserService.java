package com.ryvarden.winelottery.api.service.interfaces;

import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.User;

public interface IUserService {
    void createUser(String name, String phone);
    User getUserById(int lotteryId, int userId);

}
