package database.app_database.Controller;

import database.app_database.Dto.EmployeeDto;
import database.app_database.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = GET, value = "employees")
    public List<EmployeeDto> getAll(){
        return employeeService.getAll();
    }

}