package ar.edu.uade.inte.gym.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.bean.Factura;
import ar.edu.uade.inte.gym.dao.FacturaController;

@Named
@SessionScoped
public class FacturasMB implements Serializable{

	private static final long serialVersionUID = -8888780667484643240L;
	
	@Inject
	private  FacturaController facturasController;
	
	private List<Factura> facturas;
	
	@Inject
	private  FacturaController facturaController;

	@PostConstruct
	public void init() {
		facturas = facturaController.facturarSocios();
	}
	
	public List<Factura> getAll() {
		return facturas;
	}
}
