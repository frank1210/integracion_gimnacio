package ar.edu.uade.inte.gym.view;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.bean.Socio;
import ar.edu.uade.inte.gym.dao.SocioController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Named
@SessionScoped
public class SocioMB {

	private Socio socio = new Socio();

	@Inject
	private  SocioController socioController;

	public List<Socio> getAll() {
		return socioController.getAll();
	}

	public String create() {
		try {
			socioController.create(socio);
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return null;
	}
	

	private void showError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	

}
