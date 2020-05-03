package database.app_database.Dto;

public class SpeciesDto {
    private int id;
    private String  name;
    private String type;
    private boolean needWarmPlace;
    private  int ageForChildbirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public int getAgeForChildbirth() {
        return ageForChildbirth;
    }

    public void setAgeForChildbirth(int ageForChildbirth) {
        this.ageForChildbirth = ageForChildbirth;
    }
}
