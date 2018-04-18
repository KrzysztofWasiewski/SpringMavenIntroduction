package pl.krisloves2code.SpringIntroduction.controller.service;

import pl.krisloves2code.SpringIntroduction.controller.model.Room;
import pl.krisloves2code.SpringIntroduction.controller.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    public List<Room> getAll() {
        return (List<Room>) roomRepository.findAll();
    }

    public Room get(long id) {
        return roomRepository.findOne(id);
    }

    public void removeRoom(long id) {
        roomRepository.delete(id);
    }
}