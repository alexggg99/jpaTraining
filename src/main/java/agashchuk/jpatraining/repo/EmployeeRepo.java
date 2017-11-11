package agashchuk.jpatraining.repo;

import agashchuk.jpatraining.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

}
