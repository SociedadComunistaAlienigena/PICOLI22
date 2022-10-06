package model;

import java.util.List;

@FunctionalInterface
public interface PresupuestoCalculable {
	public long calcularPresupuesto(List<Ser> seres, int necesidadVital);
}
