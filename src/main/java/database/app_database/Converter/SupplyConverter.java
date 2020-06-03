package database.app_database.Converter;


import database.app_database.Dto.SupplyDto;
import database.app_database.Model.Feed.Supply;
import org.springframework.stereotype.Component;

@Component
public class SupplyConverter {

    public SupplyDto convert(Supply supply){
        SupplyDto dto = new SupplyDto();

        dto.setId(supply.getId());
        dto.setProviderName(supply.getProvider().getName());
        dto.setFeedName(supply.getFeed().getName());
        dto.setFeedAmount(supply.getFeedAmount());
        dto.setPrice(supply.getPrice());
        dto.setSupplyDate(supply.getSupplyDate().toString());
        return dto;
    }
}