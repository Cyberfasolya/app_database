package database.app_database.Service;

import database.app_database.Converter.AssortmentConverter;
import database.app_database.Dao.ProviderDao;
import database.app_database.Dto.AssortmentDto;
import database.app_database.Model.Feed.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssortmentService {
    @Autowired
    private ProviderDao providerDao;

    @Autowired
    private AssortmentConverter assortmentConverter;

    @Transactional
    public List<AssortmentDto> getAll() {
        List<Provider> providers = providerDao.getAll();
        return providers
                .stream()
                .map(assortmentConverter::convert)
                .collect(Collectors.toList());
    }
}