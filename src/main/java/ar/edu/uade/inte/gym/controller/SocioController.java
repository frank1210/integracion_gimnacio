package ar.edu.uade.inte.gym.controller;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.model.Socio;

@Stateless
public class SocioController extends EntityController<Socio>{

	private static final long serialVersionUID = -4094194824415288693L;

	@Override
	public Class<Socio> getEntityClass() {
		return Socio.class;
	}
	
}
