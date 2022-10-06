package model;

public class CondicionesAlimentacion {
	private int cantidad;
	private  int porcenMax;
	private int porcenMin;
	private float periodoMin;
	private float periodoMax;
	
	public CondicionesAlimentacion(int cantidad, int porcenMax, int porcenMin, float periodoMin, float periodoMax
) {
		super();
		this.cantidad = cantidad;
		this.porcenMax = porcenMax;
		this.porcenMin = porcenMin;
		this.periodoMin = periodoMin;
		this.periodoMax = periodoMax;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getPorcenMax() {
		return porcenMax;
	}

	public int getPorcenMin() {
		return porcenMin;
	}

	public float getPeriodoMin() {
		return periodoMin;
	}

	public float getPeriodoMax() {
		return periodoMax;
	}


	
}
