package bg.softuni.Pathfinder.service.impl;

import bg.softuni.Pathfinder.model.bindingModel.UserLoginBindingModel;
import bg.softuni.Pathfinder.model.bindingModel.UserRegisterBindingModel;
import bg.softuni.Pathfinder.model.entity.User;
import bg.softuni.Pathfinder.repository.UserRepository;
import bg.softuni.Pathfinder.service.AuthenticationService;
import bg.softuni.Pathfinder.service.component.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    private final LoggedUser loggedUser;

    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }


    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(user);

    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();
        User user = this.userRepository.findByUsername(username);


        if(user == null) {
            throw new IllegalArgumentException("User with username:" + username + "is not present");
        }
        boolean passwordMatch = passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword());

        if(!passwordMatch) {
            throw new IllegalArgumentException("User entered incorrect password");
        }

        loggedUser.setUsername(user.getUsername());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setFullName(user.getFullName());
        loggedUser.setLogged(true);
//ако е съвпаднала паролата и всичко е наред, значи сме се логнали
        return passwordMatch;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }
}
