package model;

import utiles.Utiles;

public class Ser {
	// schema de Ser
	private static final int vidaMax = 120;
	private static final int vidaMin = 0;
	protected int necesidadVital;
	protected float esperanzaVida;
	protected int edad = 0;

	public Ser(int necesitadVital) {
		super();
		this.esperanzaVida = this.calculaEsperanzaVida(vidaMin, vidaMax);
		this.necesidadVital=necesitadVital;
	}

	public Ser(Ser ser) {
		this.esperanzaVida = ser.esperanzaVida;
		this.edad=ser.edad;
		this.necesidadVital=ser.necesidadVital;
	}
	

	public Ser(float esperanzaVida,int necesitadVital) {
		super();
		this.esperanzaVida = esperanzaVida;
		this.necesidadVital=necesitadVital;
	}

	// comportamiento igual para todos
	public boolean vivir(int cantidad) {
		if (isAlive()) {
			cobrar(cantidad);
			envejecer();
		}
		return isAlive();
	}

	public boolean isAlive() {
		return this.edad < this.esperanzaVida;
	}

	protected void envejecer() {
		this.edad++;
	}

	protected void cobrar(int cantidad) {
		this.alimentar(cantidad);
	}

	protected void alimentar(int cantidad) {
		alimentarBase(cantidad);
	}

	protected void alimentarPersona(CondicionesAlimentacion cd) {
		float porcentaje = cd.getCantidad() * 100 / this.necesidadVital;
		if (porcentaje <= cd.getPorcenMax() && porcentaje >= cd.getPorcenMin()) {
			this.esperanzaVida -= cd.getPeriodoMin();
		} else if (porcentaje <= cd.getPeriodoMin() - 1) {
			this.esperanzaVida -= cd.getPeriodoMax();
		}
	}

	private void alimentarBase(int cantidad) {
		alimentarPersona(new CondicionesAlimentacion(
				cantidad,99, 33, 1f, 2f));
	}

	private int calculaEsperanzaVida(int minimo, int maximo) {
		return Utiles.dameNumero(maximo);
	}

	public int getEdad() {
		return edad;
	}

}
