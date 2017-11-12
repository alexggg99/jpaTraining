package agashchuk.jpatraining.controllers;

import agashchuk.jpatraining.model.Department;
import agashchuk.jpatraining.model.Project;
import agashchuk.jpatraining.model.dto.EmployeeDTO;
import agashchuk.jpatraining.repo.EmployeeRepo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/employees")
public class EmployeeResource {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping()
    public List<Department> getAll() {
        return (List<Department>) employeeRepo.geteployeesDepartment();
    }

    @GetMapping("/expression")
    public List<EmployeeDTO> getCombined() {
//        ArrayList<String> list = new ArrayList<>();
//        for (Object str : employeeRepo.geteployeesExpression()) {
//            Object[] arr = (Object[]) str;
//            list.add(arr[0].toString() + arr[1].toString());
//        }
//        return list;
        return employeeRepo.geteployeesExpression();
    }

    @GetMapping("/projects")
    public List<Project> getProjects(){
        return employeeRepo.getEmployeeProjects();
    }

    @GetMapping(value = "/join", produces = "application/json")
    public String getJoinExcludeAddress() throws JsonProcessingException {
        FilterProvider filters = new SimpleFilterProvider().addFilter("empAddress", propertyFilter("address"));
        return objectMapper.writer(filters).writeValueAsString(employeeRepo.getJoin());
    };

    @GetMapping(value = "/join2", produces = "application/json")
    public String getJoin() throws JsonProcessingException {
        FilterProvider filters = new SimpleFilterProvider().addFilter("empAddress", propertyFilter(null));
        return objectMapper.writer(filters).writeValueAsString(employeeRepo.getJoin2());
    };

    @GetMapping(value = "/countEmpInProject")
    public List<Object> countEmpInProject() {
        return employeeRepo.listNumEmpInProjects();
    }

    @GetMapping(value = "/empNumPhones", produces = "application/json")
    public String empNumPhones() throws JsonProcessingException {
        FilterProvider filters = new SimpleFilterProvider().addFilter("empAddress", propertyFilter("address"));
        return objectMapper.writer(filters).writeValueAsString(employeeRepo.empNumPhones());
    }

    @GetMapping(value = "/empWithoutProjects", produces = "application/json")
    public String empWithoutProjects() throws JsonProcessingException {
        FilterProvider filters = new SimpleFilterProvider().addFilter("empAddress", propertyFilter("address"));
        return objectMapper.writer(filters).writeValueAsString(employeeRepo.empWithoutProjects());
    }

    private PropertyFilter propertyFilter(String propertyToEscape) {
        return new SimpleBeanPropertyFilter() {
            @Override
            public void serializeAsField
                    (Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
                    throws Exception {
                if (include(writer)) {
                    //exclude "address" property
                    if (!writer.getName().equals(propertyToEscape)) {
                        writer.serializeAsField(pojo, jgen, provider);
                        return;
                    }
                } else if (!jgen.canOmitFields()) { // since 2.3
                    writer.serializeAsOmittedField(pojo, jgen, provider);
                }
            }
            @Override
            protected boolean include(BeanPropertyWriter writer) {
                return true;
            }
            @Override
            protected boolean include(PropertyWriter writer) {
                return true;
            }
        };
    }

}
