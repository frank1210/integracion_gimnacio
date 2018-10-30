package ar.edu.uade.inte.gym.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ar.edu.uade.inte.gym.controller.PersonController;
import ar.edu.uade.inte.gym.model.Person;

@Path("person")
public class PersonService {
	
	@Inject
	private PersonController personCtl;

	@GET
	public Response getAll (){
		List<Person> allPersons = personCtl.getAll();
		return Response
                .ok(allPersons)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
	
}
