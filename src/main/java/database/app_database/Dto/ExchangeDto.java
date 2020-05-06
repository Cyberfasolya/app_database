package database.app_database.Dto;

public class ExchangeDto {
    private ZooDto zoo;
    private AnimalDto animal;
    private boolean side;

    public ZooDto getZoo() {
        return zoo;
    }

    public void setZoo(ZooDto zoo) {
        this.zoo = zoo;
    }

    public AnimalDto getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDto animal) {
        this.animal = animal;
    }

    public boolean isSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }
}
