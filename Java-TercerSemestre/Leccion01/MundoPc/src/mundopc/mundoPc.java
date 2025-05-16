package mundopc;

import ar.com.system2024.mundopc.*;

public class mundoPc {
    public static void main(String[] args){
        Monitor monitorHP = new Monitor("HP", 13); //importar la clase
        Teclado tecladoHP = new Teclado ("Bluetooth", "HP");
        Raton ratonHP = new Raton ("Bluetooh","HP");
        Computadora computadoraHP = new Computadora("Computadora HP", monitorHP, tecladoHP, ratonHP);
        
        //creamos objetos diferentes
        Monitor monitorGamer = new Monitor("HP", 32); //importar la clase
        Teclado tecladoGamer = new Teclado ("Bluetooth", "Gamer");
        Raton ratonGamer = new Raton ("Bluetooh","Gamer");
        Computadora computadoraGamer = new Computadora("Computadora HP", monitorGamer, tecladoGamer, ratonGamer);
        
       
        Orden orden1 = new Orden();// inicializamos el arreglo vacio
        Orden orden2= new Orden(); // una nueva lista
        orden1.agregarComputadora(computadoraHP);
        orden1.agregarComputadora(computadoraGamer);
        
        Computadora computadorasVarias = new Computadora("Computadora Gamer", monitorGamer, tecladoGamer, ratonGamer);
        orden2.agregarComputadora(computadorasVarias);
        
        orden1.mostrarOrden();
        orden2.mostrarOrden();
        
        
        //Crear mas objetos de tipo computadora con todos sus elementos
        // completar una lista en el objeto ordenj1 que llegue a los 10 elementos
        //pobar de esta mnera los metodos al maximo rendimiento 
    }
    
}
