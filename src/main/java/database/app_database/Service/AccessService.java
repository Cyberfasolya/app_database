package database.app_database.Service;

import database.app_database.Converter.AccessConverter;
import database.app_database.Dao.AccessDao;
import database.app_database.Dto.AccessDto;
import database.app_database.Model.Employee.AccessWorker.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessService {
    @Autowired
    private AccessDao accessDao;

    @Autowired
    private AccessConverter accessConverter;


    @Transactional
    public List<AccessDto> getAll() {
        List<Access> accesses = accessDao.getAll();
        return accesses
                .stream()
                .map(accessConverter::convert)
                .collect(Collectors.toList());
    }
}