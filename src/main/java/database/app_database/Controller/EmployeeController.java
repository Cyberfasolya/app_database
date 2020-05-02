package database.app_database.Controller;

import database.app_database.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

//    @RequestMapping(method = GET, value = "recipes")
//    public List<BaseRecipeDto> getAll(){
//        return recipeService.getAll();
//    }

}