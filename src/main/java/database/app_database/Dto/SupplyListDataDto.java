package database.app_database.Dto;

import java.util.List;

public class SupplyListDataDto {
    private List<SupplyDto> supplies;
    private Integer numberOfSupplies;

    public List<SupplyDto> getSupplies() {
        return supplies;
    }

    public void setSupplies(List<SupplyDto> supplies) {
        this.supplies = supplies;
    }

    public Integer getNumberOfSupplies() {
        return numberOfSupplies;
    }

    public void setNumberOfSupplies(Integer numberOfSupplies) {
        this.numberOfSupplies = numberOfSupplies;
    }
}
