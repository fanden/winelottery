package com.ryvarden.winelottery.api.service;
import com.ryvarden.winelottery.api.model.Lottery;
import com.ryvarden.winelottery.api.model.User;
import com.ryvarden.winelottery.api.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private List<User> userList;
    private int userCount;

    public UserService(List<User> userList) {
        this.userList = userList;
        this.userCount = 0;
    }

    public void createUser(String name, String phone) {
        userList.add(new User(userCount, name, phone));
        userCount++;
    }

    // TODO Implement method
    @Override
    public User getUserById(int lotteryId, int userId) {
        return null;
    }
}
