package bg.softuni.Pathfinder.controller;

import bg.softuni.Pathfinder.model.dto.viewModel.UserProfileViewModel;
import bg.softuni.Pathfinder.model.dto.viewModel.bindingModel.UserLoginBindingModel;
import bg.softuni.Pathfinder.model.dto.viewModel.bindingModel.UserRegisterBindingModel;
import bg.softuni.Pathfinder.model.serviceModel.UserServiceModel;
import bg.softuni.Pathfinder.service.AuthenticationService;
import bg.softuni.Pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final AuthenticationService authenticationService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UsersController(AuthenticationService authenticationService, ModelMapper modelMapper, UserService userService) {
        this.authenticationService = authenticationService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginBindingModel userLoginBindingModel) {
        boolean isLogged = authenticationService.login(userLoginBindingModel);

        if(isLogged) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("login");
    }

//    @PostMapping("/register")
//    public ModelAndView register(UserRegisterBindingModel userRegisterBindingModel) {
//        this.authenticationService.register(userRegisterBindingModel);
//
//        return new ModelAndView("redirect:login");
//    }
@PostMapping("/register")
public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
            .equals(userRegisterBindingModel.getConfirmPassword())) {
        redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
        return "redirect:register";
    }
    authenticationService.register(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

    return "redirect:login";
}
//TODO change to POST
    @GetMapping("/logout")
    @PostMapping("/logout")
    public ModelAndView logout() {
       this.authenticationService.logout();
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/profile")
    public ModelAndView profile(){
        UserProfileViewModel userProfileViewModel = userService.getUserProfile();
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("userProfileViewModel", userProfileViewModel);
        return modelAndView;
    }


}
