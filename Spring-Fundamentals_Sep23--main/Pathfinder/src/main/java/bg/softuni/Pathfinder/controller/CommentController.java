package bg.softuni.Pathfinder.controller;


import bg.softuni.Pathfinder.model.dto.viewModel.bindingModel.CreateCommentBindingModel;
import bg.softuni.Pathfinder.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/comments")
    public class CommentController {

        private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/create")
        public ModelAndView create(CreateCommentBindingModel createCommentBindingModel) {
            commentService.create(createCommentBindingModel);

            return new ModelAndView("redirect:/routes/details/" + createCommentBindingModel.getRouteId());
        }

        @PatchMapping("/{id}/approve/{routeId}")
        public ModelAndView approve(@PathVariable("id") Long id, @PathVariable("routeId") Long routeId) {
            commentService.approve(id);

            return new ModelAndView("redirect:/routes/details/" + routeId);
        }

        @DeleteMapping("/{id}/{routeId}")
        public ModelAndView delete(@PathVariable("id") Long id, @PathVariable("routeId") Long routeId) {
            commentService.delete(id);

            return new ModelAndView("redirect:/routes/details/" + routeId);
        }
    }

