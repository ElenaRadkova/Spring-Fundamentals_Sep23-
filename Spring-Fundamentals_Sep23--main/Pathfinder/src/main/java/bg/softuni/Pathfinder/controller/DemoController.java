package bg.softuni.Pathfinder.controller;

import bg.softuni.Pathfinder.model.entity.User;


import bg.softuni.Pathfinder.service.DemoUserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class DemoController {
    private final DemoUserService userService;

    public DemoController(DemoUserService userService) {
        this.userService = userService;
    }


    @RequestMapping(path= "/all", method = RequestMethod.GET)
    //@GetMapping("/users/all")
    public List<User> getAll() {
        return this.userService.getAll();
    }



}
