package database.app_database.Converter;

import database.app_database.Dto.ProviderDto;
import database.app_database.Model.Feed.Provider;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    public ProviderDto convert(Provider provider) {
        ProviderDto dto = new ProviderDto();
        dto.setId(provider.getId());
        dto.setName(provider.getName());
        return dto;
    }
}