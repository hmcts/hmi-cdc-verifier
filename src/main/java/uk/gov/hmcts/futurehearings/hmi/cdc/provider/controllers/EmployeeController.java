package uk.gov.hmcts.futurehearings.hmi.cdc.provider.controllers;

import uk.gov.hmcts.futurehearings.hmi.cdc.provider.dao.EmployeeDAO;
import uk.gov.hmcts.futurehearings.hmi.cdc.provider.dto.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @RequestMapping(value = "/employees", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Employee> getEmployees()
    {
        return employeeDao.getAllEmployees().getEmployeeList();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Employee> getEmployee(@RequestParam(value = "id", defaultValue = "1") String id)
    {
        return new ResponseEntity<Employee>(employeeDao.getEmployee(Integer.parseInt(id)),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.POST,
            consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> persistPerson(@PathVariable("id") long id,
                                                 @ModelAttribute Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
