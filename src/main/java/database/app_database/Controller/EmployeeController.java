package database.app_database.Controller;

import database.app_database.Dto.EmployeeDto;
import database.app_database.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = GET, value = "employees")
    public List<EmployeeDto> getAll(@RequestParam(required = false) String role,
                                    @RequestParam(required = false) String gender,
                                    @RequestParam(required = false) Integer lowSalary,
                                    @RequestParam(required = false) Integer highSalary,
                                    @RequestParam(required = false) Integer durationOfWorkHigh,
                                    @RequestParam(required = false) Integer durationOfWorkLow) {
        return employeeService.getAll(role, gender, lowSalary, highSalary, durationOfWorkLow, durationOfWorkHigh);
    }

    @RequestMapping(method = POST, value = "employee")
    public void create(@RequestBody final EmployeeDto employeeDto) {
        employeeService.create(employeeDto);
    }

    @RequestMapping(method = GET, value = "access-employees")
    public List<EmployeeDto> getAccessEmployeesByInfo(@RequestParam(required = false) String animalName,
                                                      @RequestParam(required = false) String species,
                                                      @RequestParam(required = false) Integer lowAmount,
                                                      @RequestParam(required = false) Integer highAmount) {
        return employeeService.getAccessEmployeesByInfo(animalName, species, lowAmount, highAmount);
    }
}