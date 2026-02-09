
public class Circulo{
    public static void main(String[] args) {

        CalcularCirco circo = new CalcularCirco(5.0);

        System.out.println("Area: " + circo.calcularArea());
        System.out.println("Perimetro: " + circo.calcularPerimetro());
    }
}
