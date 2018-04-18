package pl.krisloves2code.SpringIntroduction.controller.repository;

import pl.krisloves2code.SpringIntroduction.controller.model.Meeting;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {
}