package employee_management.repository;

import employee_management.database.EmployeeDB;
import employee_management.exception.InValidSalaryException;
import employee_management.exception.NotFoundException;
import employee_management.model.Employee;

import java.util.ArrayList;

public class EmployeeRepository {
    public ArrayList<Employee> findAll() {
        return EmployeeDB.employees;
    }

    public void save(Employee employee) {
        EmployeeDB.employees.add(employee);
    }

    public ArrayList<Employee> findByNameContainsIgnoreCase(String name) {
        ArrayList<Employee> rs = new ArrayList<>();
        for (Employee e : EmployeeDB.employees) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(e);
            }
        }

        return rs;
    }

    public Employee findById(int id) {
        for (Employee e : EmployeeDB.employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new NotFoundException("Not found employee with id = " + id);
    }

    public void deleteById(int id) {
        Employee employee = findById(id);
        EmployeeDB.employees.remove(employee);

        // Sử dụng lambda
        // EmployeeDB.employees.removeIf(e -> e.getId() == id);
    }

    public ArrayList<Employee> findBySalary(int minSalary, int maxSalary) {
        if(minSalary >= maxSalary) {
            throw new InValidSalaryException("minSalary không được >= maxSalary");
        }

        ArrayList<Employee> rs = new ArrayList<>();
        for (Employee e : EmployeeDB.employees) {
            if (e.getSalary() >= minSalary && e.getSalary() <= maxSalary) {
                rs.add(e);
            }
        }

        return rs;
    }
}
