package employee_management.repository;

import employee_management.database.EmployeeDB;
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
        return null;
    }

    public void deleteById(int id) {
    }

    public ArrayList<Employee> findBySalary(int minSalary, int maxSalary) {
        return null;
    }
}
