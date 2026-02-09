
public class Rectangulo {
	
	 double ancho;
	 double alto;
	
	public Rectangulo(double ancho,double alto) {
		this.alto = alto;
		this.ancho = ancho;
	}
	public void calcularArea(double ancho, double alto) {
			System.out.println( "El area del rectangulo es = " + ancho * alto);
	}
}
