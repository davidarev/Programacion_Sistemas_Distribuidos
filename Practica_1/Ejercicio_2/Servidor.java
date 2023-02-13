import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null; //Creo el socket del servidor
        Socket sc = null; //Creo el socket del cliente
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5002; //Puerto

        try {
            servidor = new ServerSocket(PUERTO); //Creo el socket del servidor
            System.out.println("Servidor iniciado");

            while(true) {
                sc = servidor.accept(); //Acepto la conexion del cliente
                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF(); //Recibo el mensaje del cliente
                System.out.println(mensaje);
                out.writeUTF("Hola cliente, soy el server"); //Envio un mensaje al cliente

                //CODIGO AÑADIDO
                double radio = in.readDouble(); //Recibo el radio del cliente
                double area = calcularAreaCirculo(radio); //Calculo el area del circulo
                out.writeDouble(area); //Envio el area al cliente

                sc.close(); //Cierro el socket del cliente
                System.out.println("Cliente desconectado");
            }
        } catch(IOException ex){
            Logger.getLogger(Servidor.class.getCanonicalName()).log(Level.SEVERE, null, ex); //Muestro el error
        }
    }

    public static double calcularAreaCirculo(double radio) {
        Circulo circulo = new Circulo(radio);
        return circulo.calcularArea();
    }
}
