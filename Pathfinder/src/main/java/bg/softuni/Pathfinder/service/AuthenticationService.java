package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.bindingModel.UserLoginBindingModel;
import bg.softuni.Pathfinder.model.bindingModel.UserRegisterBindingModel;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
     void register(UserRegisterBindingModel userRegisterBindingModel);
     boolean login(UserLoginBindingModel userLoginBindingModel);

     void logout();

}
