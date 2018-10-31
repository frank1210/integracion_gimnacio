package ar.edu.uade.inte.gym.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.bean.Abono;
import ar.edu.uade.inte.gym.bean.Servicio;
import ar.edu.uade.inte.gym.bean.Socio;
import ar.edu.uade.inte.gym.bean.TipoDeClase;
import ar.edu.uade.inte.gym.dao.AbonoController;
import ar.edu.uade.inte.gym.dao.ServicioController;
import ar.edu.uade.inte.gym.dao.SocioController;
import ar.edu.uade.inte.gym.dao.TipoDeClaseController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Named
@SessionScoped
public class TipoDeClaseMB implements Serializable{

	private static final long serialVersionUID = -8888780667484643240L;

	private TipoDeClase tipoDeClase = new TipoDeClase();
	
	@Inject
	private TipoDeClaseController tipoDeClaseController;

	@PostConstruct
	public void init() {
	}
	
	public List<TipoDeClase> getAll() {
		return tipoDeClaseController.getAll();
	}

	public String showCreateView() {
		tipoDeClase = new TipoDeClase();
		return "nuevaTipoDeClase";
	}
	
	public String showEditView(Socio socio) {
		return "nuevaTipoDeClase";
	}
	
	public String create() {
		try {
			tipoDeClaseController.create(tipoDeClase);
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return "admClases";
	}
	
	private void showError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}

	public TipoDeClase getTipoDeClase() {
		return tipoDeClase;
	}

	public void setTipoDeClase(TipoDeClase tipoDeClase) {
		this.tipoDeClase = tipoDeClase;
	}
	
}
