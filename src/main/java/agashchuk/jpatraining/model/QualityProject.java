package agashchuk.jpatraining.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("quality")
public class QualityProject extends Project {
}
