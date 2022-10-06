package model;

public class ControlSer {

	public static Ser crearSer(int necesidad) {
		return new Menor(necesidad);
	}

	public static Ser crearSer(int esperanza,int necesidad) {
		return new Menor(esperanza,necesidad);
	}

	public static Ser controlarEtapas(Ser ser) {
		if (ser.getEdad() == 18)
			return new Adulto(ser);
		if (ser.getEdad() == 65)
			return new Ser(ser);
		return ser;
	}
}
