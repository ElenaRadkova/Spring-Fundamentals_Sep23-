package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.dto.viewModel.bindingModel.CreateCommentBindingModel;

public interface CommentService {
    void create(CreateCommentBindingModel createCommentBindingModel);

    void approve(Long id);

    void delete(Long id);
}
