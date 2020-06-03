package database.app_database.Service;

import database.app_database.Converter.ProviderConverter;
import database.app_database.Dao.ProviderDao;
import database.app_database.Dto.ProviderDto;
import database.app_database.Model.Feed.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    @Autowired
    private ProviderDao providerDao;

    @Autowired
    private ProviderConverter providerConverter;

    @Transactional
    public List<ProviderDto> getAll() {
        List<Provider> providers = providerDao.getAll();
        return providers
                .stream()
                .map(providerConverter::convert)
                .collect(Collectors.toList());
    }
}