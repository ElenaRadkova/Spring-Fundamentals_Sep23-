package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DemoUserService {
    List<User> getAll();
}
