package ar.edu.uade.inte.gym.controller;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.model.Empleado;

@Stateless
public class EmpleadoController extends EntityController<Empleado>{

	private static final long serialVersionUID = 6509489797808821132L;

	@Override
	public Class<Empleado> getEntityClass() {
		return Empleado.class;
	}
	
}
