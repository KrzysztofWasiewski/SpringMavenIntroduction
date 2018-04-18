package pl.krisloves2code.SpringIntroduction.controller;

        import pl.krisloves2code.SpringIntroduction.controller.model.Employee;
        import pl.krisloves2code.SpringIntroduction.controller.service.EmployeeService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ModelAndView allEmployee() {
        ModelAndView modelAndView = new ModelAndView("allEmployees");
        modelAndView.addObject("employees", employeeService.getAll());
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listOfEmployees() {
        ModelAndView modelAndView = new ModelAndView("allEmployeesList");
        modelAndView.addObject("employees", employeeService.getAll());
        return modelAndView;
    }

    @PostMapping
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees"; /**/
    }

    @GetMapping("/view/{id}")
    public ModelAndView getEmployee(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("employee");
        modelAndView.addObject("employee", employeeService.get(id));
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id) {
        employeeService.removeEmployee(id);
        return "redirect:/employees";
    }
}

