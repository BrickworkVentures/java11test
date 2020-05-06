package ch.brickwork.javatest.repository;

import ch.brickwork.javatest.domain.Thing;
import org.springframework.data.repository.CrudRepository;

public interface ThingRepository extends CrudRepository<Thing, Long> {
}
