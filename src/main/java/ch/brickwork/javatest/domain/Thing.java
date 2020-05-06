package ch.brickwork.javatest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Thing {

  @Id
  private long id;

  private String name;

}
