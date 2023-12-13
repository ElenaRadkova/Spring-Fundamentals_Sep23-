package bg.softuni.Pathfinder.repository;


import bg.softuni.Pathfinder.model.entity.Categories;
import bg.softuni.Pathfinder.model.enums.CategoriesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {

    Set<Categories> findByNameIn(Set<CategoriesEnum> categories);

}
