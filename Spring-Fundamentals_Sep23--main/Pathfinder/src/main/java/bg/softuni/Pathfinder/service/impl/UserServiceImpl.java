package bg.softuni.Pathfinder.service.impl;

import bg.softuni.Pathfinder.exceptions.UserNotFoundException;
import bg.softuni.Pathfinder.model.dto.viewModel.UserProfileViewModel;
import bg.softuni.Pathfinder.model.entity.User;
import bg.softuni.Pathfinder.repository.UserRepository;
import bg.softuni.Pathfinder.service.UserService;
import bg.softuni.Pathfinder.service.component.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }


    @Override
    public User getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername());
    }
    @Override
    public boolean isUniqueUsername(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }
    @Override
    public boolean isUniqueEmail(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }

    @Override
    public UserProfileViewModel getUserProfile() {
       User user = userRepository.findByUsername(loggedUser.getUsername());
//               .orElseThrow(() -> new UserNotFoundException("User not found!"));

       return modelMapper.map(user, UserProfileViewModel.class);
    }
}
