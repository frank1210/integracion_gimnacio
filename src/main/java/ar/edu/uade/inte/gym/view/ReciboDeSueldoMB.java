package ar.edu.uade.inte.gym.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.bean.ReciboDeSueldo;
import ar.edu.uade.inte.gym.dao.ReciboDeSueldoController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Named
@SessionScoped
public class ReciboDeSueldoMB implements Serializable{

	private static final long serialVersionUID = -8888780667484643240L;
	
	@Inject
	private  ReciboDeSueldoController reciboDeSueldoController;

	public String liquidarTodo() {
		try {
			reciboDeSueldoController.liquidar();
		} catch (Invalid e) {
			e.printStackTrace();
			showError("Error interno");
		}
		return null;
	}
	

	private void showError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}
	
	public List<ReciboDeSueldo> getAll() {
		return reciboDeSueldoController.getAll();
	}
}
