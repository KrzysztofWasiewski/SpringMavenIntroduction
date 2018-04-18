package pl.krisloves2code.SpringIntroduction.controller;


import pl.krisloves2code.SpringIntroduction.controller.model.Room;
import pl.krisloves2code.SpringIntroduction.controller.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rooms")
public class RoomController {


    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ModelAndView allRoom() {
        ModelAndView modelAndView = new ModelAndView("allRooms");
        modelAndView.addObject("rooms", roomService.getAll());
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listOfRooms() {
        ModelAndView modelAndView = new ModelAndView("allRoomsList");
        modelAndView.addObject("rooms", roomService.getAll());
        return modelAndView;
    }


    @PostMapping
    public String saveRoom(@ModelAttribute Room room) {
        roomService.saveRoom(room);
        return "redirect:/rooms";
    }

    @GetMapping("/view/{id}")
    public ModelAndView getRoom(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("room");
        modelAndView.addObject("room", roomService.get(id));
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteRoom(@PathVariable("id") long id) {
        roomService.removeRoom(id);
        return "redirect:/rooms";
    }
}