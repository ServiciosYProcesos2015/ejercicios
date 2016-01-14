/*
Crea dos hilos, los cuales no se ejecuten secuencialmente, de tal manera que
el hilo 1 muestre por pantalla la palabra un mensaje de bienvenida y la iteración
en la que se encuentra y el hilo 2 muestre pon pantalla “soy el hilo 2 y es mi ciclo número”
durante 10 ciclos, y que una vez finalizados muestre un mensaje que diga”Finaliza el hilo**”
y además una vez finalizados muestre el mensaje “main terminado”. (Recordar que para que
aparezca el mensaje del main cuando acaban los hilos hay que usar .join)
*/



















class Hilo1 extends Thread{
    @Override
    public void run(){
        System.out.println("Bienvenido, soy el hilo 1");
        for(int i=1;i<=10;i++) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {break; }
            System.out.println("Iteración del hilo1: " + i);
        }
        System.out.println("Hilo 1 terminado");
    }
}

class Hilo2 extends Thread{
    @Override
    public void run(){
        System.out.println("Comienzo del hilo 2");
        for(int i=1;i<=10;i++) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {break; }
            System.out.println("Soy el hilo 2 y este es mi ciclo: " + i);
        }
        System.out.println("Hilo 2 terminado");
    }
}


public class JoinHilos {


    public static void main(String[] args) {
        Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2 = new Hilo2();

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        }catch(InterruptedException e){
            System.out.println("¡Proceso interrumido!");
        }

        System.out.println("Main terminado");
    }

}

