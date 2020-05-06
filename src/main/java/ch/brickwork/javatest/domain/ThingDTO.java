package ch.brickwork.javatest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@NamedNativeQuery(name = "ThingDTO.findAll", resultClass = ThingDTO.class, query =
    "SELECT t.* FROM thing t")

@Getter
@Setter
@Entity // This is required if DTO should be used for query methods in Spring Repositories
@NoArgsConstructor
@Relation(collectionRelation = "things")
public class ThingDTO {

    @Id
    private Long id;

    private String name;

}
