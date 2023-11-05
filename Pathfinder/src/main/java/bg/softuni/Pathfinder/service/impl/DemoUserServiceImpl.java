package bg.softuni.Pathfinder.service.impl;

import bg.softuni.Pathfinder.model.entity.User;
import bg.softuni.Pathfinder.repository.UserRepository;
import bg.softuni.Pathfinder.service.DemoUserService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DemoUserServiceImpl implements DemoUserService {
    private final UserRepository userRepository;

    public DemoUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
