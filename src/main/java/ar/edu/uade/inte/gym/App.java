package ar.edu.uade.inte.gym;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class App extends Application{

	
	@PostConstruct
	public void init()
	{
		// Esto se llama cada vez que se deploya la aplicación... la base puede ya tener cosas de antes ya que se borra cada vez que se levanta el server y no la appp
	}
}