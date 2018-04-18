package pl.krisloves2code.SpringIntroduction.controller;


import pl.krisloves2code.SpringIntroduction.controller.model.Meeting;
import pl.krisloves2code.SpringIntroduction.controller.service.EmployeeService;
import pl.krisloves2code.SpringIntroduction.controller.service.MeetingService;
import pl.krisloves2code.SpringIntroduction.controller.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/meetings")
public class MeetingController {


    private MeetingService meetingService;
    private RoomService roomService;
    private EmployeeService employeeService;

    @Autowired
    public MeetingController(MeetingService meetingService, RoomService roomService, EmployeeService employeeService) {
        this.meetingService = meetingService;
        this.roomService = roomService;
        this.employeeService = employeeService;
    }

    /*get wczyta mi m.in. dodane wczesniejsze pokoje i pracownikow*/
    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("allMeetings");
        modelAndView.addObject("meetings", meetingService.getAll());
        modelAndView.addObject("availableRooms", roomService.getAll());
        modelAndView.addObject("availableEmployee", employeeService.getAll());
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listOfMeetings() {
        ModelAndView modelAndView = new ModelAndView("allMeetingsList");
        modelAndView.addObject("meetings", meetingService.getAll());
        return modelAndView;
    }

    /*dodawanie meetignow*/
    @PostMapping
    public String addOne(@ModelAttribute Meeting meeting) {
        meetingService.addOne(meeting);
        return "redirect:/meetings";
    }

    /*usuwanie meetingow*/
    @GetMapping(value = "/delete/{id}")
    public String deleteRoom(@PathVariable("id") long id) {
        meetingService.removeMeeting(id);
        return "redirect:/meetings";
    }

    @GetMapping("/view/{id}")
    public ModelAndView getMeeting(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("meeting");
        modelAndView.addObject("meeting", meetingService.get(id));
        return modelAndView;
    }
}