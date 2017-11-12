package agashchuk.jpatraining.repo;

import agashchuk.jpatraining.model.Department;
import agashchuk.jpatraining.model.Employee;
import agashchuk.jpatraining.model.Project;
import agashchuk.jpatraining.model.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

    @Query("Select distinct e.department from Employee e")
    List<Department> geteployeesDepartment();

    @Query("Select new agashchuk.jpatraining.model.dto.EmployeeDTO(e.name, e.address.street) from Employee e")
    List<EmployeeDTO> geteployeesExpression();

    @Query("SELECT p FROM Project p WHERE p.employees IS NOT EMPTY")
    List<Project> getEmployeeProjects();

    @Query("SELECT e FROM Employee e")
    List<Employee> getJoin();

    @Query("SELECT e  FROM Employee e LEFT JOIN FETCH e.address a")
    List<Employee> getJoin2();

    @Query("select p, count(e) from Project p join p.employees e group by p")
    List<Object> listNumEmpInProjects();

    @Query("select e, count(p) from Employee e join e.phone p group by e")
    List<Object> empNumPhones();

    @Query("select e from Employee e where e.projects is empty")
    List<Employee> empWithoutProjects();
}
