package bg.softuni.Pathfinder.service.impl;

import bg.softuni.Pathfinder.model.entity.User;
import bg.softuni.Pathfinder.repository.UserRepository;
import bg.softuni.Pathfinder.service.UserService;
import bg.softuni.Pathfinder.service.component.LoggedUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }


    @Override
    public User getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername());
    }
}
