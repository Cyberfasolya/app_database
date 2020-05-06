package database.app_database.Service;

import database.app_database.Converter.AnimalConverter;
import database.app_database.Converter.ZooConverter;
import database.app_database.Dao.ZooDao;
import database.app_database.Dto.AnimalDto;
import database.app_database.Dto.ZooDto;
import database.app_database.Model.Animal.Animal;
import database.app_database.Model.Exchange.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZooService {
    @Autowired
    private ZooDao zooDao;

    @Autowired
    private ZooConverter zooConverter;

    @Transactional
    public List<ZooDto> getAll() {
        List<Zoo> recipes = zooDao.getAll();
        return recipes
                .stream()
                .map(zooConverter::convert)
                .collect(Collectors.toList());
    }
}