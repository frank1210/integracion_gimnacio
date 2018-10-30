package ar.edu.uade.inte.gym;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ar.edu.uade.inte.gym.controller.PersonController;
import ar.edu.uade.inte.gym.exception.Invalid;
import ar.edu.uade.inte.gym.model.Person;

@ApplicationPath("api")
public class App extends Application{

	@Inject
	private PersonController personCtl;
	
	@PostConstruct
	public void init()
	{
		// Esto se llama cada vez que se deploya la aplicación... la base puede ya tener cosas de antes ya que se borra cada vez que se levanta el server y no la appp
	}
}