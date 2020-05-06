package ch.brickwork.javatest.controller;

import ch.brickwork.javatest.domain.Thing;
import ch.brickwork.javatest.domain.ThingDTO;
import ch.brickwork.javatest.repository.ThingRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThingCustomController {

  private final ThingRepository thingRepository;

  public ThingCustomController(ThingRepository thingRepository) {
    this.thingRepository = thingRepository;
  }

  @RequestMapping(value = "/customthings", method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_JSON})
  public ResponseEntity<org.springframework.hateoas.CollectionModel<org.springframework.hateoas.EntityModel<ThingDTO>>> findResourcesWithinTimeFrameAndRoleIn() {
    final List<org.springframework.hateoas.EntityModel<ThingDTO>> things = new ArrayList<>();
    for (Thing thing : thingRepository.findAll()) {
      final ThingDTO thingDTO = new ThingDTO();
      thingDTO.setId(thing.getId());
      thingDTO.setName(thing.getName());
      things.add(new org.springframework.hateoas.EntityModel<>(thingDTO));
    }
    return ResponseEntity.ok(new org.springframework.hateoas.CollectionModel<>(things));
  }
}
