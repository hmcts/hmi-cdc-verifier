package uk.gov.hmcts.futurehearings.hmi.cdc.provider.dao;

import uk.gov.hmcts.futurehearings.hmi.cdc.provider.dto.Employee;
import uk.gov.hmcts.futurehearings.hmi.cdc.provider.dto.Employees;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO {

    private static Employees list = new Employees();

    static
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
    }

    public Employees getAllEmployees()
    {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
    public Employee getEmployee(Integer id) {
       for (Employee e : list.getEmployeeList()) {
           if (e.getId().equals(id)) {
              return e;
           }
       }
       throw new RuntimeException("There is no Employee for this given id");
    }
}
