package com.rest.rest.controller;
import com.rest.rest.pojo.UserPojo;
import com.rest.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserPojo userPojo) {
        try {
            return ResponseEntity.ok().body(userService.createUser(userPojo));
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(500).body("Error");
        }
    }

    @GetMapping("/")
    public List<Map<String, Object>> getAllUsers() {
        return  userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Map<String,Object> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/")
    public String deleteAllUser() {
        userService.deleteAllUser();
        return "All users have been deleted successfully.";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return id + " is deleted";
    }

}
