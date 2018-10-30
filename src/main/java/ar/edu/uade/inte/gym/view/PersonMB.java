package ar.edu.uade.inte.gym.view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.controller.PersonController;
import ar.edu.uade.inte.gym.exception.Invalid;
import ar.edu.uade.inte.gym.model.Person;

@Named
@RequestScoped
public class PersonMB {

	private Person person;

	@Inject
	private PersonController personCntr;

	public List<Person> getAll() {
		return personCntr.getAll();
	}

	public void delete(Person user) {
		try {
			personCntr.delete(user);
		} catch (Invalid e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), e.getMessage()));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error interno", e.getMessage()));
		}
	}
	
	public String create() {
		try {
			personCntr.create(person);
		} catch (Invalid e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), e.getMessage()));
			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error interno", e.getMessage()));
			return null;
		}
		return "users";
	}

	public String update() {
		try {
			personCntr.update(person);
		} catch (Invalid e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), e.getMessage()));
			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error interno", e.getMessage()));
			return null;
		}
		return "users";
	}

}
