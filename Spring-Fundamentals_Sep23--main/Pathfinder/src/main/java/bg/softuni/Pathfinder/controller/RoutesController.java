package bg.softuni.Pathfinder.controller;

import bg.softuni.Pathfinder.model.dto.viewModel.bindingModel.AddRouteBidingModel;
import bg.softuni.Pathfinder.model.enums.CategoriesEnum;
import bg.softuni.Pathfinder.model.enums.SectionEnum;
import bg.softuni.Pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/routes")
public class RoutesController {
    private final RouteService routeService;

    public RoutesController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/add")
    public ModelAndView addRoute(){
        ModelAndView modelAndView = new ModelAndView("add-reservation");

        modelAndView.addObject("sections", SectionEnum.values());
        modelAndView.addObject("categories", CategoriesEnum.values());

        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteBidingModel addRouteBidingModel){
        routeService.add(addRouteBidingModel);
        return new ModelAndView("redirect:/");
    }
}
