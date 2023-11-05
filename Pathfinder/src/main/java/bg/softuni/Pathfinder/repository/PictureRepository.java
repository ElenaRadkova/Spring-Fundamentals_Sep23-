package bg.softuni.Pathfinder.repository;

import bg.softuni.Pathfinder.model.entity.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Pictures, Long> {
}
