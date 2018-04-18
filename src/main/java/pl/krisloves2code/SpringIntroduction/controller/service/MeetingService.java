package pl.krisloves2code.SpringIntroduction.controller.service;


import pl.krisloves2code.SpringIntroduction.controller.model.Meeting;
import pl.krisloves2code.SpringIntroduction.controller.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    private MeetingRepository meetingRepository;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    /*zwraca liste mettignow*/
    public List<Meeting> getAll() {
        return (List<Meeting>) meetingRepository.findAll();
    }

    public void addOne(Meeting meeting) {
        meetingRepository.save(meeting);
    }


    public void removeMeeting(long id) {
        meetingRepository.delete(id);
    }

    public Meeting get(long id) {
        return meetingRepository.findOne(id);
    }
}