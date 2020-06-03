package database.app_database.Service;

import database.app_database.Converter.SupplyConverter;
import database.app_database.Dao.SupplyDao;
import database.app_database.Dto.SupplyDto;
import database.app_database.Model.Feed.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplyService {
    @Autowired
    private SupplyDao supplyDao;

    @Autowired
    private SupplyConverter supplyConverter;

    @Transactional
    public List<SupplyDto> getAll() {
        List<Supply> supplies = supplyDao.getAll();
        return supplies
                .stream()
                .map(supplyConverter::convert)
                .collect(Collectors.toList());
    }
}