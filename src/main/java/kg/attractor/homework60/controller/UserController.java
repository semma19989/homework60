package kg.attractor.homework60.controller;


import kg.attractor.homework60.dto.UserDTO;
import kg.attractor.homework60.model.Users;
import kg.attractor.homework60.repository.UsersRepository;
import kg.attractor.homework60.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UsersRepository ur;

    UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping("/registration")
    public Users createUser(@RequestParam("email")String email, @RequestParam("name")String name,
                            @RequestParam("login")String login, @RequestParam("password")String password){
        var user = new Users(UUID.randomUUID().toString(), name, login, email, password);
        user.setPassword(user.getPassword());
        ur.save(user);
        return user;
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return us.createUser(userDTO);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteUser(@PathVariable("name") String name){
        us.deleteUsersByName(name);
    }

    @GetMapping("/name/{name}")
    public UserDTO getUserByName (@PathVariable("name") String name){
        return us.getUserByName(name);
    }

    @GetMapping("/mail/{mail}")
    public UserDTO getUserByMail (@PathVariable("mail") String mail){
        return us.getUserByMail(mail);
    }

    @GetMapping("/exist/{mail}")
    public boolean existUserByMail (@PathVariable("mail") String mail) {
        return us.existUserByMail(mail);
    }
}