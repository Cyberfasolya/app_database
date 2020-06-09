package database.app_database.Dto;

import java.util.List;

public class MenuDto {
    private int id;
    private SpeciesDto speciesDto;
    private String season;
    private List<MenuContentDto> menuContents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SpeciesDto getSpeciesDto() {
        return speciesDto;
    }

    public void setSpeciesDto(SpeciesDto speciesDto) {
        this.speciesDto = speciesDto;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<MenuContentDto> getMenuContents() {
        return menuContents;
    }

    public void setMenuContents(List<MenuContentDto> menuContents) {
        this.menuContents = menuContents;
    }
}
