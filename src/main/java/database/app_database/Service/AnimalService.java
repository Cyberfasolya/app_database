package database.app_database.Service;

import database.app_database.Converter.AnimalConverter;
import database.app_database.Dao.AnimalDao;
import database.app_database.Dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalDao animalDao;

    @Autowired
    AnimalConverter animalConverterr;

//    @Transactional
//    public List<EmployeeDto> getAll() {
//       
//        return converter.convertAllEmployees(rolesMap);
//    }
}