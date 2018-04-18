package pl.krisloves2code.SpringIntroduction.controller.repository;

import pl.krisloves2code.SpringIntroduction.controller.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}