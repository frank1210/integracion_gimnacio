package ar.edu.uade.inte.gym.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Socio extends Persona implements Serializable{
	
	private static final long serialVersionUID = 1635523978951895899L;

	@ManyToMany
	private List<Servicio> servicios = new ArrayList<>();

	@ManyToOne
	private Abono abonos;
	
	private boolean aptoFisico;
	
	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Abono getAbonos() {
		return abonos;
	}

	public void setAbonos(Abono abonos) {
		this.abonos = abonos;
	}

	public boolean isAptoFisico() {
		return aptoFisico;
	}

	public void setAptoFisico(boolean aptoFisico) {
		this.aptoFisico = aptoFisico;
	}
	
	
	
}