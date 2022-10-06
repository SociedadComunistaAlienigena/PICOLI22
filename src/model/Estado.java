package model;

import java.util.LinkedList;

public class Estado {
	// propiedades
	private LinkedList<Ser> poblacion;
	private LinkedList<Ser> trabajadores;
	private LinkedList<Ser> parados;
	private LinkedList<Ser> menores;
	private LinkedList<Ser> ancianos;
	private final int produccionPorTrabajador=400;
	private final int necesidadVitalBase=100;
	private long capital=0;
	long presupuestoParados;

	// funciones a realizar
	public void gestionarPeriodo(float incremento) {
		cerrarPeriodoAnterior();
		abrirPeriodoActual(incremento);
	}

	private long calcularPresupuesto() {
		long presupuesto=calcularPresupuestoMenores();
		presupuesto+= calcularPresupuestoParados();
		presupuesto+=calcularPresupuestoAncianos();
		presupuesto+=calcularPresupuestoTrabajadores();
		return presupuesto;
	}
	
	private long calcularPresupuestoMenores() {
		return menores.size()*necesidadVitalBase;
	}
	private long calcularPresupuestoAncianos() {
		return ancianos.size()*necesidadVitalBase/2;
	}
	private long calcularPresupuestoTrabajadores() {
		return trabajadores.size()*necesidadVitalBase*2;		
	}
	private long calcularPresupuestoParados() {
		parados.forEach((parado)->{
			long saldo=((Adulto)parado).getAhorros()-necesidadVitalBase;
			if(saldo<0) {
				presupuestoParados+=Math.abs(saldo);
			}
		});
		return presupuestoParados;
	}
	
	private void abrirPeriodoActual(float incremento) {
		long demandaProxima=calculaDemanda(incremento);
		long diferencia=demandaProxima-calcularProduccionTotal();
		gestionEmpleados(diferencia);
		gestionNacimientos();
	}

	private void gestionNacimientos() {
		// TODO Auto-generated method stub
		
	}

	private void gestionEmpleados(long diferencia) {
		// TODO Auto-generated method stub
		
	}

	private long calculaDemanda(float incremento) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void cerrarPeriodoAnterior() {
		pagarPoblacion();
		envejecerPoblacion();
		enterrarMuertos();
	}

	private void enterrarMuertos() {
		// TODO Auto-generated method stub
		
	}

	private void envejecerPoblacion() {
		poblacion.forEach((ser)->{ser.envejecer();});		
	}

	private void pagarPoblacion() {
		capital+=calcularProduccionTotal();
		long pagoParados=pagarAParados();
		capital-=pagoParados;
		pagarATrabajadores();
		pagoAMenores();
		pagoAAncianos();
	}

	private int calcularProduccionTotal() {
		return trabajadores.size()*produccionPorTrabajador;
	}

	private void pagarATrabajadores() {
		// TODO Auto-generated method stub
		
	}

	private void pagoAAncianos() {
		// TODO Auto-generated method stub
		
	}

	private void pagoAMenores() {
		// TODO Auto-generated method stub
		
	}

	private long pagarAParados() {
		// TODO Auto-generated method stub
		return 0;
	}
}
