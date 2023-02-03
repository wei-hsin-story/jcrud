package demo.crud.controller;

import demo.crud.ApiDaemon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


import demo.crud.service.UserService;
import demo.crud.model.User;
import demo.crud.utils.*;


@Api(tags = "API", description = "")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class APIController {

    @Value("${security.salt}")
    private String salt;

    @Autowired
    private UserService user_service;

    @Autowired
    private Common fun;

    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(ApiDaemon.class);

    @ApiOperation(value = "List Users record", notes = "List Users in the system.")
    @GetMapping("/listUsers")
    ResponseEntity<List<User>> getUsers() {
        List<User> listUsers = user_service.getUsers();
        if (listUsers != null)
            return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
        else
            return new ResponseEntity<List<User>>((List<User>) null, HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "List User record", notes = "List User in the system.")
    @GetMapping("/listUser/{id}")
    ResponseEntity<User> getUser(@PathVariable String id) {
        User User = user_service.getUser(id);

        if (User != null)
            return new ResponseEntity<User>(User, HttpStatus.OK);
        else
            return new ResponseEntity<User>((User) null, HttpStatus.BAD_REQUEST);

    }

    @ApiOperation(value = "Add User record", notes = "Add User in the system.")
    @PostMapping("/createUser")
    ResponseEntity<User> createUser(@RequestBody User user) {
        user.setPassword(fun.hashing(user.getPassword()));
        User User = user_service.addUser(user);

        if (User != null)
            return new ResponseEntity<User>(User, HttpStatus.OK);
        else
            return new ResponseEntity<User>((User) null, HttpStatus.BAD_REQUEST);

    }

    @ApiOperation(value = "Delete User record", notes = "Delete User in the system.")
    @DeleteMapping("/deleteUser/{id}")
    ResponseEntity<User> deleteUser(@PathVariable String id) {
        User User = user_service.deleteUser(id);

        if (User != null)
            return new ResponseEntity<User>(User, HttpStatus.OK);
        else
            return new ResponseEntity<User>((User) null, HttpStatus.BAD_REQUEST);


    }


    @ApiOperation(value = "List User record", notes = "List User in the system.")
    @PutMapping("/updateUser")
    ResponseEntity<User> UpdateUser(@RequestBody User user) {
        user.setPassword(fun.hashing(user.getPassword()));
        User User = user_service.updateUser(user);

        if (User != null)
            return new ResponseEntity<User>(User, HttpStatus.OK);
        else
            return new ResponseEntity<User>((User) null, HttpStatus.BAD_REQUEST);



    }
}
