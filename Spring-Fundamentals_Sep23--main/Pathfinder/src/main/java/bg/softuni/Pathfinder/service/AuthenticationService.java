package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.dto.viewModel.bindingModel.UserLoginBindingModel;
import bg.softuni.Pathfinder.model.serviceModel.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
     void register(UserServiceModel userServiceModel);
     boolean login(UserLoginBindingModel userLoginBindingModel);

     void logout();

}
