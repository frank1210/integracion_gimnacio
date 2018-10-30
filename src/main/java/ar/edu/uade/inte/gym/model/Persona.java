package ar.edu.uade.inte.gym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column (nullable = false, length = 20)
	private String nombre;
	
	@NotNull
	@Column (nullable = false, length = 14,unique = true)
	private String dni;
	
	@Column (nullable = false, length = 25)
	private String mail;
	
	@Column (nullable = false, length = 20)
	private String apellido;
	
	@Column (nullable = false, length = 50)
	private String domicilio;
	
	
	

}

