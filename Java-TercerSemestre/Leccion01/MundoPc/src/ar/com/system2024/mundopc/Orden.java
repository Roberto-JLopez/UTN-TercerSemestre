package ar.com.system2024.mundopc;

public class Orden {
    private final int idOrden;
    private Computadora computadora []; // arreglo de objetos
    private static int contadorOrdenes;
    private static final int MAX_COMPUTADORAS = 10;
    private int contadorComputadora;
    
    //contructor vacio
    
    public Orden (){
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadora = new Computadora[Orden.MAX_COMPUTADORAS];    
    }
     // metodo para AGREGAR UNA NUEVA COMPUTADORA AL ARREGLO
    public void agregarComputadora (Computadora computadora){
         if(this.contadorComputadora < Orden.MAX_COMPUTADORAS){
             this.computadora[this.contadorComputadora++]=computadora;
         }
         else {
             System.out.println ("Has superado el liumite: "+ Orden.MAX_COMPUTADORAS);
         }
    }
    //Mostrar oden
    public void mostrarOrden (){
        System.out.println ("Orden #: "+this.idOrden);
        System.out.println("Computadoras de la orden #:"+this.idOrden);
        for(int i = 0; i < this.contadorComputadora; i++){
    
            System.out.println(this.computadora[i]);
        }  
    }
      
}
