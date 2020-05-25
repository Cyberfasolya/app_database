package database.app_database.Converter;

import database.app_database.Dao.Roles;
import database.app_database.Dto.EmployeeDto;
import database.app_database.Model.Employee.AccessWorker.Cleaner;
import database.app_database.Model.Employee.AccessWorker.Trainer;
import database.app_database.Model.Employee.AccessWorker.Vet;
import database.app_database.Model.Employee.Administrator;
import database.app_database.Model.Employee.BuilderWorker;
import database.app_database.Model.Employee.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {

    public EmployeeDto convertEmployee(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setGender(employee.getGender());
        dto.setMonthlySalary(employee.getMonthlySalary());
        dto.setName(employee.getName());
        dto.setSurname(employee.getSurname());
        dto.setWorkStartDate(employee.getWorkStartDate());

        employee.accept(new Employee.EmployeeVisitor<Void>() {
            @Override
            public Void visit(BuilderWorker builderWorker) {
                dto.setRole(Roles.builderWorker.toString());
                dto.setRoleAttribute(builderWorker.getBuildingForRepair());
                return null;
            }

            @Override
            public Void visit(Administrator administrator) {
                dto.setRole(Roles.administrator.toString());
                dto.setRoleAttribute(administrator.getCabinetNumber());
                return null;
            }

            @Override
            public Void visit(Cleaner cleaner) {
                dto.setRole(Roles.cleaner.toString());
                dto.setRoleAttribute(cleaner.getPantryNumber());
                return null;
            }

            @Override
            public Void visit(Trainer trainer) {
                dto.setRole(Roles.trainer.toString());
                dto.setRoleAttribute(trainer.getHallNumber());
                return null;
            }

            @Override
            public Void visit(Vet vet) {
                dto.setRole(Roles.vet.toString());
                dto.setRoleAttribute(vet.getLaboratoryNumber());
                return null;
            }
        });

        return dto;
    }
}
