package agashchuk.jpatraining.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String number;
    @Enumerated(EnumType.STRING)
    private Type type;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_ID")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
