package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.entity.User;
import bg.softuni.Pathfinder.model.dto.viewModel.UserProfileViewModel;

public interface UserService {
    User getLoggedUser();

    UserProfileViewModel getUserProfile();
    boolean isUniqueUsername(String value);
    boolean isUniqueEmail(String value);
}
