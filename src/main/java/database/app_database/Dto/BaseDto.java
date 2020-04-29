package database.app_database.Dto;

public class BaseDto {

    public Integer id;

    public BaseDto() {
    }

    public BaseDto(final int id) {
        this.id = id;
    }

    public BaseDto(final HasId hasId) {
        this.id = hasId.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public interface HasId {

        Integer getId();

    }

}
