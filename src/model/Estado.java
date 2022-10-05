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
	private long capital=0;

	// funciones a realizar
	public void gestionarPeriodo(float incremento) {
		cerrarPeriodoAnterior();
		abrirPeriodoActual(incremento);
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
		long pagoTrabajadores=pagarATrabajadores();
		capital-=pagoTrabajadores;
		long pagoMenores=pagoAMenores();
		capital-=pagoMenores;
		long pagoAncianos=pagoAAncianos();
		capital-=pagoAncianos;
	}

	private int calcularProduccionTotal() {
		return trabajadores.size()*produccionPorTrabajador;
	}
	
	private long calcularPresupuestado() {
		long presupuesto=pagarAParados()+pagarATrabajadores()+pagoAAncianos()+pagoAMenores();
		
		return 0;
		
	}

	private long pagarATrabajadores() {
		int cantidad=0;
		for (Ser ser : trabajadores) {
			cantidad = ser.necesidadVital*2;
			ser.cobrar(cantidad);
		}
		return cantidad;
		
	}

	private long pagoAAncianos() {
		int cantidad=0;
		for (Ser ser : ancianos) {
			cantidad = ser.necesidadVital/2;
			ser.cobrar(cantidad);
		}
		
		return cantidad;
		
	}

	private long pagoAMenores() {
		int cantidad=0;
		for (Ser ser : menores) {
			cantidad = ser.necesidadVital;
			ser.cobrar(cantidad);
		}
		return cantidad;
		
	}

	private long pagarAParados() {
		int cantidad=0;
		for (Ser ser : parados) {
			Adulto adulto=new Adulto(ser);
			cantidad = ser.necesidadVital;
			if(adulto.ahorros>=ser.necesidadVital) {
				ser.cobrar(cantidad);
				cantidad=0;
			}else {
				ser.cobrar(cantidad);
				cantidad = ser.necesidadVital;
			}
			
		}
		return cantidad;
	}
}
