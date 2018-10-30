package ar.edu.uade.inte.gym.model;

import javax.persistence.Entity;

@Entity
public class Profesor extends Empleado{
	
	private int precioHs;
	
	private int horas;

	public int getPrecioHs() {
		return precioHs;
	}

	public void setPrecioHs(int precioHs) {
		this.precioHs = precioHs;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
}