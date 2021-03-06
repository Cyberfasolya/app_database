package database.app_database.Service;

import database.app_database.Converter.SupplyConverter;
import database.app_database.Dao.FeedDao;
import database.app_database.Dao.ProviderDao;
import database.app_database.Dao.SupplyDao;
import database.app_database.Dto.SupplyDto;
import database.app_database.Dto.SupplyListDataDto;
import database.app_database.Model.Feed.Feed;
import database.app_database.Model.Feed.Provider;
import database.app_database.Model.Feed.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplyService {
    @Autowired
    private SupplyDao supplyDao;

    @Autowired
    private ProviderDao providerDao;

    @Autowired
    private FeedDao feedDao;

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

    @Transactional
    public void create(SupplyDto supplyDto) {
        Supply supply = new Supply();

        LocalDate supplyDate = LocalDate.parse(supplyDto.getSupplyDate());
        supply.setSupplyDate(supplyDate.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant());

        supply.setFeedAmount(supplyDto.getFeedAmount());
        supply.setPrice(supplyDto.getPrice());

        Provider provider = providerDao.getByName(supplyDto.getProviderName());
        supply.setProvider(provider);

        Feed feed = feedDao.getByName(supplyDto.getFeedName());
        supply.setFeed(feed);

        supplyDao.persist(supply);
    }

    @Transactional
    public SupplyListDataDto getByBasicInfo(String feedName, Integer lowAmount, Integer highAmount,
                                            Integer lowPeriod, Integer highPeriod, Integer lowPrice, Integer highPrice, String feedNamePart, String providerNamePart,
                                            String sortingAttribute, String sortingType, Integer page) {
        Instant lowDate = lowPeriod == null ? null : ZonedDateTime.now().minusYears(lowPeriod).toInstant();
        Instant highDate = highPeriod == null ? null : ZonedDateTime.now().minusYears(highPeriod).toInstant();

        List<Supply> supplies = supplyDao.getByBasicInfo(feedName, lowAmount, highAmount, highDate, lowDate, lowPrice,
                highPrice, feedNamePart, providerNamePart, sortingAttribute, sortingType, page);
        List<SupplyDto> supplyDtos = supplies
                .stream()
                .map(supplyConverter::convert)
                .collect(Collectors.toList());

        SupplyListDataDto dto = new SupplyListDataDto();
        dto.setSupplies(supplyDtos);
        supplies = supplyDao.getSuppliesForQuery(feedName, lowAmount, highAmount, highDate, lowDate, lowPrice,
                highPrice, feedNamePart, providerNamePart, sortingAttribute, sortingType);
        dto.setNumberOfSupplies(supplies.size());

        return dto;
    }
}