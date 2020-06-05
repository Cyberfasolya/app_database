package database.app_database.Dto;

import database.app_database.Model.Employee.AccessWorker.AccessWorker;

import java.time.Instant;

public class AccessDto {
    private String employeeName;
    private String employeeSurname;
    private String animalName;
    private String species;
    private String accessStartDate;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurame(String employeeSurame) {
        this.employeeSurname = employeeSurame;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAccessStartDate() {
        return accessStartDate;
    }

    public void setAccessStartDate(String accessStartDate) {
        this.accessStartDate = accessStartDate;
    }
}
