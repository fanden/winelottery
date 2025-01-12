package com.ryvarden.winelottery.api.service.interfaces;

import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.User;

import java.util.Optional;

public interface IUserService {
    void createUser(String name, String phone);
    Optional<User> getUserById(int userId);

}
