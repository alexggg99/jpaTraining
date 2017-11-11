package agashchuk.jpatraining.controllers;

import agashchuk.jpatraining.model.Employee;
import agashchuk.jpatraining.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/employees")
public class EmployeeResource {

    @Autowired
    EmployeeRepo EmployeeRepo;

    @GetMapping()
    public List<Employee> getAll() {
        return (List<Employee>) EmployeeRepo.findAll();
    }

}
