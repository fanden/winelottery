package com.ryvarden.winelottery.api.controller;
import com.ryvarden.winelottery.api.model.DTO.UserCreateDTO;
import com.ryvarden.winelottery.api.model.User;
import com.ryvarden.winelottery.api.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
// Versioning is important for future compatability, in case changes are needed to the API
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO.getName(), userCreateDTO.getPhone());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId){
        Optional<User> user = userService.getUserById(userId);

        return user
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


    }

}
