package bg.softuni.Pathfinder.repository;


import bg.softuni.Pathfinder.model.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Messages, Long> {
}
