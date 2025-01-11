package com.ryvarden.winelottery.api.controller;
import com.ryvarden.winelottery.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
// Versioning is important for future compatability, in case changes are needed to the API
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public void createUser(@RequestParam int id, @RequestParam String name){
        userService.createUser(id, name);
    }

}
