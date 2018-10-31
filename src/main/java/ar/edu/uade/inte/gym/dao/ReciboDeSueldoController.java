package ar.edu.uade.inte.gym.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ar.edu.uade.inte.gym.bean.Administrativo;
import ar.edu.uade.inte.gym.bean.Clase;
import ar.edu.uade.inte.gym.bean.Profesor;
import ar.edu.uade.inte.gym.bean.ReciboDeSueldo;
import ar.edu.uade.inte.gym.exception.Invalid;

@Stateless
public class ReciboDeSueldoController extends EntityController<ReciboDeSueldo>{

	private static final long serialVersionUID = 6266719709947160418L;

	@Inject
	private ClaseController claseController;
	
	@Inject
	private ProfesorController profesorController;
	
	@Inject
	private AdministrativoController administrativoController;
	
	
	@Override
	public Class<ReciboDeSueldo> getEntityClass() {
		return ReciboDeSueldo.class;
	}
	
	public void liquidar() throws Invalid {
		List<Profesor> profesores = profesorController.getAll();
		for (Profesor profesor : profesores) {
			List<Clase> clases = claseController.porProfesor(profesor);
			int monto = 0;
			for (Clase clase : clases) {
				int hs = clase.getTipoDeClase().getHoras();
				monto = monto +  hs * profesor.getPrecioHs();
			}
			ReciboDeSueldo rds = new ReciboDeSueldo();
			rds.setEmpleado(profesor);
			rds.setMonto(profesor.getSueldoBasico() + monto);
			create(rds);
		}
		List<Administrativo> administrativos = administrativoController.getAll();
		for (Administrativo administrativo : administrativos) {
			ReciboDeSueldo rds = new ReciboDeSueldo();
			rds.setEmpleado(administrativo);
			rds.setMonto(administrativo.getSueldoBasico());
			create(rds);
		}
	}
}
