package database.app_database.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DefaultController {

    @RequestMapping(method = GET, value = "/get")
    defaultDto getDefault() {
        var result = new defaultDto();
        return new defaultDto();
    }

    private class defaultDto {
        public Long id;

    }

//    @RequestMapping(method = GET, value = "employee/ids")
//    List<Long> getEmployeeIds() {
//        return
//    }
}
