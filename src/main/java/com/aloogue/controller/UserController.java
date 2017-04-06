package com.aloogue.controller;

import com.aloogue.model.user.UserApp;
import com.aloogue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "userapp")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserApp> login(@RequestParam String email, @RequestParam String password) {
        UserApp userApp = userService.login(email, password);
        if (userApp != null) {
            return new ResponseEntity<>(userApp, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new UserApp(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserApp> saveUser(@RequestBody UserApp userApp) {
        return userService.saveUser(userApp);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserApp userApp) {
        userService.saveUser(userApp);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody UserApp userApp) {
        userService.deleteUser(userApp);
    }

}
