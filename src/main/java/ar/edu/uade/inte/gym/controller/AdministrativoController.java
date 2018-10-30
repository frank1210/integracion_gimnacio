package ar.edu.uade.inte.gym.controller;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.model.Administrativo;

@Stateless
public class AdministrativoController extends EntityController<Administrativo>{

	private static final long serialVersionUID = 6593570497985894620L;

	@Override
	public Class<Administrativo> getEntityClass() {
		return Administrativo.class;
	}
	
}
