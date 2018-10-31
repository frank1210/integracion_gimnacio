package ar.edu.uade.inte.gym.dao;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.bean.Profesor;

@Stateless
public class ProfesorController extends EntityController<Profesor>{

	private static final long serialVersionUID = 5570046968160556665L;

	@Override
	public Class<Profesor> getEntityClass() {
		return Profesor.class;
	}
	
}
