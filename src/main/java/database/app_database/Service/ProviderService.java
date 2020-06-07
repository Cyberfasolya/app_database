package database.app_database.Service;

import database.app_database.Converter.ProviderConverter;
import database.app_database.Dao.FeedDao;
import database.app_database.Dao.ProviderDao;
import database.app_database.Dao.SupplyDao;
import database.app_database.Dto.AssortmentDto;
import database.app_database.Dto.ProviderDto;
import database.app_database.Model.Feed.Feed;
import database.app_database.Model.Feed.Provider;
import database.app_database.Model.Feed.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    @Autowired
    private ProviderDao providerDao;

    @Autowired
    private SupplyDao supplyDao;

    @Autowired
    private FeedDao feedDao;

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

    @Transactional
    public void create(ProviderDto providerDto) {
        Provider provider = new Provider();

        provider.setName(providerDto.getName());
        providerDao.persist(provider);
    }

    @Transactional
    public void addAssortment(AssortmentDto assortmentDto) {
        Provider provider = providerDao.getByName(assortmentDto.getProviderName());
        Feed feed = feedDao.getByName(assortmentDto.getFeeds().get(0));
        provider.addFeed(feed);
    }

    @Transactional
    public List<ProviderDto> getByBasicInfo(String feedName, Integer lowAmount, Integer highAmount,
                                            Integer lowPeriod, Integer highPeriod, Integer lowPrice, Integer highPrice) {
        Instant lowDate = lowPeriod == null ? null : ZonedDateTime.now().minusYears(lowPeriod).toInstant();
        Instant highDate = highPeriod == null ? null : ZonedDateTime.now().minusYears(highPeriod).toInstant();

        List<Supply> supplies = supplyDao.getByBasicInfo(feedName, lowAmount, highAmount, highDate, lowDate, lowPrice, highPrice);
        return supplies
                .stream()
                .map(Supply::getProvider)
                .distinct()
                .map(providerConverter::convert)
                .collect(Collectors.toList());
    }
}