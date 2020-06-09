package database.app_database.Converter;

import database.app_database.Dto.MenuContentDto;
import database.app_database.Dto.MenuDto;
import database.app_database.Model.Feed.Menu.Menu;
import database.app_database.Model.Feed.Menu.MenuContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MenuConverter {

    @Autowired
    private SpeciesConverter speciesConverter;

    @Autowired
    private FeedConverter feedConverter;

    public MenuDto convert(Menu menu) {
        MenuDto dto = new MenuDto();

        dto.setSeason(menu.getSeason());
        dto.setSpeciesDto(speciesConverter.convertSpecies(menu.getSpecies()));
        dto.setMenuContents(menu.getMenuContents().stream()
                .map(this::convertMenuContent)
                .collect(Collectors.toList()));

        return dto;
    }

    private MenuContentDto convertMenuContent(MenuContent menuContent) {
        MenuContentDto dto = new MenuContentDto();

        dto.setFeedAmount(menuContent.getFeedAmount());
        dto.setFeedDto(feedConverter.convert(menuContent.getFeed()));

        return dto;
    }
}
