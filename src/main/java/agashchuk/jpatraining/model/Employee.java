package agashchuk.jpatraining.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private long salary;
    @OneToMany(mappedBy = "employee")
    Set<Phone> phone = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    Set<Project> projects = new HashSet<>();
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Set<Phone> getPhone() {
        return phone;
    }

    public void setPhone(Set<Phone> phoneList) {
        this.phone = phoneList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
