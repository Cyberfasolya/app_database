package database.app_database.Dto;

public class SpeciesDto {
    private int id;
    private String type;
    private boolean needWarmPlace;
    private  boolean ageForChildbirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNeedWarmPlace() {
        return needWarmPlace;
    }

    public void setNeedWarmPlace(boolean needWarmPlace) {
        this.needWarmPlace = needWarmPlace;
    }

    public boolean isAgeForChildbirth() {
        return ageForChildbirth;
    }

    public void setAgeForChildbirth(boolean ageForChildbirth) {
        this.ageForChildbirth = ageForChildbirth;
    }
}
