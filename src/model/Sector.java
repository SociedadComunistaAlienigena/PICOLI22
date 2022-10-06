package model;

import java.util.LinkedList;

public class Sector {
	protected LinkedList<Ser> seres;
	protected int necesidadVital;
	private PresupuestoCalculable presupuestoCalculable;

	public Sector(int necesidadVital,PresupuestoCalculable presupuestoCalculable) {
		super();
		this.seres = new LinkedList<>();
		this.necesidadVital = necesidadVital;
		this.presupuestoCalculable=presupuestoCalculable;
	}
	
	public int size() {
		return seres.size();
	}

	public long calcularPresupuesto() {
		return presupuestoCalculable.calcularPresupuesto(this.seres,this.necesidadVital);
	}

	
	
		
}
