package agashchuk.jpatraining.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("design")
public class DesignProject extends Project {
}
