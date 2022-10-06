package model;

public class Estado {
	// propiedades
	private Sector trabajadores;
	private Sector parados;
	private Sector menores;
	private Sector ancianos;
	private final int produccionPorTrabajador = 400;
	private final int necesidadVitalBase = 100;
	private long capital = 0;
	long presupuestoParados;

	public Estado() {
		super();
		crearSectores();
	}

	private void crearSectores() {
		PresupuestoCalculable base = (seres, necesidad) -> {
			return seres.size() * necesidad;
		};
		menores = new Sector(necesidadVitalBase, base);
		ancianos = new Sector(necesidadVitalBase / 2, base);
		trabajadores = new Sector(necesidadVitalBase, (seres, necesidadVitalBase) -> {
			return seres.size() * necesidadVitalBase * 2;
		});
		parados = new Sector(necesidadVitalBase, (seres, necesidad) -> {
			return seres.stream().mapToLong((parado) -> {
				return ((Adulto)parado).calcularNecesidadSegunAhorros();
			}).sum();
		});
	}

	// funciones a realizar
	public void gestionarPeriodo(float incremento) {
		cerrarPeriodoAnterior();
		abrirPeriodoActual(incremento);
	}

	private long calcularPresupuesto() {
		long presupuesto = menores.calcularPresupuesto();
		presupuesto += parados.calcularPresupuesto();
		presupuesto += ancianos.calcularPresupuesto();
		presupuesto += trabajadores.calcularPresupuesto();
		return presupuesto;
	}

	private void abrirPeriodoActual(float incremento) {
		long demandaProxima = calculaDemanda(incremento);
		long diferencia = demandaProxima - calcularProduccionTotal();
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
//		envejecerPoblacion();
		enterrarMuertos();
	}

	private void enterrarMuertos() {
		// TODO Auto-generated method stub

	}

//	private void envejecerPoblacion() {
//		poblacion.forEach((ser) -> {
//			ser.envejecer();
//		});
//	}

	private void pagarPoblacion() {
		capital += calcularProduccionTotal();
		long pagoParados = pagarAParados();
		capital -= pagoParados;
		pagarATrabajadores();
		pagoAMenores();
		pagoAAncianos();
	}

	private int calcularProduccionTotal() {
		return trabajadores.size() * produccionPorTrabajador;
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
