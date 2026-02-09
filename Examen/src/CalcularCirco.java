public class CalcularCirco {

    
    double radio;

    
    public CalcularCirco(double radio) {
        this.radio = radio;
    }

   
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

   
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}
