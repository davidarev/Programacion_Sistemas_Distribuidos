class Circulo {
    //Atributos
    double radio;

    //Constructor
    public Circulo(double radio) {
        this.radio = radio;
    }

    //Metodo para calcular el area del circulo
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}
