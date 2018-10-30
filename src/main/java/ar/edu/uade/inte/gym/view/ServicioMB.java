package ar.edu.uade.inte.gym.view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.controller.AbonoController;
import ar.edu.uade.inte.gym.controller.ServicioController;
import ar.edu.uade.inte.gym.exception.Invalid;
import ar.edu.uade.inte.gym.model.Persona;
import ar.edu.uade.inte.gym.model.Servicio;

@Named
@RequestScoped
public class ServicioMB {

	private Servicio servicio;

	@Inject
	private  ServicioController servicioController;

	public List<Servicio> getAll() {
		return servicioController.getAll();
	}

	public String create() {
		try {
			servicioController.create(servicio);
		} catch (Invalid e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), e.getMessage()));
			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error interno", e.getMessage()));
			return null;
		}
		return null;
	}

}
