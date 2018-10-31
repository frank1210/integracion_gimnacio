package ar.edu.uade.inte.gym.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ar.edu.uade.inte.gym.bean.Factura;
import ar.edu.uade.inte.gym.bean.Servicio;
import ar.edu.uade.inte.gym.bean.Socio;

@Stateless
public class FacturaController extends EntityController<Factura>{

	private static final long serialVersionUID = 1486293642539272419L;

	@Override
	public Class<Factura> getEntityClass() {
		return Factura.class;
	}
	
	@Inject
	private SocioController socioController;
		
		private Factura facturar(Socio socio) throws RemoteException{
			double monto=0;
			for(Servicio servicio: socio.getServicios())
				monto+= servicio.getCosto();
			monto= (monto* socio.getAbono().getDias()) - socio.getAbono().getDescuento();
			Factura factura= new Factura();
			factura.setSocio(socio);
			factura.setMonto(monto);
			return factura;
		}
		
		public List<Factura> facturarSocios(){
			try {
				List<Factura> facturas = new ArrayList<Factura>();
				List<Socio> socios = socioController.getAll();
				for(Socio socio: socios){
					facturas.add(facturar(socio));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}

	
	
}
