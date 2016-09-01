package ccv.dam.isi.frsf.utn.edu.ar.lab01c2016;

/**
 * Created by Administrador on 25/08/2016.
 */
public class LogicaModelo {

    public static double calcularInteres(int dias, double monto, double tasa){


        return monto*(Math.pow((1+tasa),(dias/360.0))-1);


    }

}
