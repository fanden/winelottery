package com.ryvarden.winelottery.api.service.interfaces;

import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.User;

public interface IUserService {
    void createUser(int id, String name);
    User getUserById(Lottery lottery, int userId);

}
