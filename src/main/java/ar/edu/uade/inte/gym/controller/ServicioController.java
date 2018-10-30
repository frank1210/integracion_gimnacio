package ar.edu.uade.inte.gym.controller;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.model.Servicio;

@Stateless
public class ServicioController extends EntityController<Servicio>{

	private static final long serialVersionUID = -4856174465195742618L;

	@Override
	public Class<Servicio> getEntityClass() {
		return Servicio.class;
	}
	
}
