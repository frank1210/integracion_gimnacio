package ar.edu.uade.inte.gym.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ar.edu.uade.inte.gym.model.Person;

@Stateless
public class PersonController extends EntityController<Person>{

	private static final long serialVersionUID = -6462265816138356686L;

	@Override
	public Class<Person> getEntityClass() {
		return Person.class;
	}
	
	public Person findByName(String name) {
		EntityManager em = getEntityManager();
		String jpql = "Select e from Person e where e.name = :name";
		TypedQuery<Person> q = em.createQuery(jpql, Person.class);
		q.setParameter("name", name);
		return q.getSingleResult();
	}

}
