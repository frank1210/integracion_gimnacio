package ar.edu.uade.inte.gym.controller;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.model.Profesor;

@Stateless
public class ProfesorController extends EntityController<Profesor>{

	private static final long serialVersionUID = 5570046968160556665L;

	@Override
	public Class<Profesor> getEntityClass() {
		return Profesor.class;
	}
	
}
