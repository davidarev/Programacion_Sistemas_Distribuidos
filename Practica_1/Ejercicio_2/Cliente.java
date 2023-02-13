import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1"; //localhost
        final int PUERTO = 5002; //Puerto
        DataInputStream in;
        DataOutputStream out;

        Scanner teclado = new Scanner(System.in); //Creo un objeto Scanner para leer datos del usuario

        try {
            Socket sc = new Socket(HOST, PUERTO); //Creo el socket
            //Creo los flujos de entrada y salida
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            //Envio un mensaje al servidor
            out.writeUTF("Hola server, soy el cliente"); //Envio un mensaje al servidor
            String mensaje = in.readUTF(); //Recibo el mensaje del servidor
            System.out.println(mensaje);

            //EJERCICIO 2
            System.out.println("Introduce el radio del círculo: "); //Pido el radio al usuario
            double radio = teclado.nextDouble(); //Recibo el radio del usuario
            out.writeDouble(radio); //Envio el radio al servidor
            double area = in.readDouble(); //Recibo el area del servidor
            System.out.println("El área del círculo es: " + area); //Muestro el area

            sc.close(); //Cierro el socket
        }
        catch(IOException ex) {
            Logger.getLogger(Servidor.class.getCanonicalName()).log(Level.SEVERE, null, ex); //Muestro el error
        }
    }
}
