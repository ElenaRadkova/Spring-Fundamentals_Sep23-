package bg.softuni.Pathfinder.model.dto.viewModel.bindingModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCommentBindingModel {

    private long routeId;
    private String textContent;
}
