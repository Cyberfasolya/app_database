package database.app_database.Dto;

import database.app_database.Model.Employee.AccessWorker.AccessWorker;

import java.time.Instant;

public class AccessDto {
    private AccessWorker accessWorker;//employee
    private AnimalDto animal;
    private Instant accessStartDate;

    public AccessWorker getAccessWorker() {
        return accessWorker;
    }

    public void setAccessWorker(AccessWorker accessWorker) {
        this.accessWorker = accessWorker;
    }

    public AnimalDto getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDto animal) {
        this.animal = animal;
    }

    public Instant getAccessStartDate() {
        return accessStartDate;
    }

    public void setAccessStartDate(Instant accessStartDate) {
        this.accessStartDate = accessStartDate;
    }
}
