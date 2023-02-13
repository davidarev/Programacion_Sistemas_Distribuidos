import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); //Creo un objeto Scanner para leer datos del usuario
        System.out.print("Introduce el radio del círculo: ");
        double radio = teclado.nextDouble(); //Recibo el radio del usuario
        Circulo circle = new Circulo(radio); //Creo el circulo, cuyo radio es el que ha introducido el usuario
        System.out.println("El área del círculo es: " + circle.calcularArea()); //Calculo el area y lo muestro por pantalla
    }
}
