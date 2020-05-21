package database.app_database.Service;

import database.app_database.Converter.ZooConverter;
import database.app_database.Dao.ZooDao;
import database.app_database.Dto.SpeciesDto;
import database.app_database.Dto.ZooDto;
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
    public List<ZooDto> getAll(Integer speciesId) {
        List<Zoo> zoos = zooDao.getAll(speciesId);
        return zoos
                .stream()
                .map(zooConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(ZooDto zooDto) {
        Zoo zoo = new Zoo();

        zoo.setName(zooDto.getName());
        zooDao.persist(zoo);
    }
}