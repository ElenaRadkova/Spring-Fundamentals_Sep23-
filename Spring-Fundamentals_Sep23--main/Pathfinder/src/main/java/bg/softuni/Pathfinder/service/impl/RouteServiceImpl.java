package bg.softuni.Pathfinder.service.impl;

import bg.softuni.Pathfinder.model.dto.viewModel.bindingModel.AddRouteBidingModel;
import bg.softuni.Pathfinder.model.entity.Categories;
import bg.softuni.Pathfinder.model.entity.Route;

import bg.softuni.Pathfinder.model.entity.User;
import bg.softuni.Pathfinder.repository.CategoryRepository;
import bg.softuni.Pathfinder.repository.RouteRepository;
import bg.softuni.Pathfinder.service.RouteService;
import bg.softuni.Pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, CategoryRepository categoryRepository, UserService userService, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(AddRouteBidingModel addRouteBidingModel) {
        Route route = modelMapper.map(addRouteBidingModel, Route.class);
        route.getCategories().clear();

        Set<Categories> categories = categoryRepository.findByNameIn(addRouteBidingModel.getCategories());
        route.addCategories(categories);

         User user = userService.getLoggedUser();
         route.setAuthor(user);

        routeRepository.save(route);

    }
}
