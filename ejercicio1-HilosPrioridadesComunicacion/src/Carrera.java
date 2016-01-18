/*
 Realiza un programa en el que crees una clase llamada Animal y
 tres objetos de dicha clase: Tortuga, liebre, guepardo. Asigna un hilo
 a cada uno de ellos de forma que se ejecuten concurrentemente y  utiliza
 la asignación de prioridades para establecer quién llegará el primero.
 */


public class Carrera {


    static class Animal extends Thread {
        String nombre;

        public Animal(String nombre) {
            this.nombre = nombre;
        }

        public void run() {
            System.out.println(System.currentTimeMillis() +":!"+this.nombre + " empieza a correr!");
            for (int i=0; i<10; i++) {
                try{
                    Thread.sleep(500);
                    System.out.println(this.nombre + " va por el metro "+i+"...");
                }catch (InterruptedException e){break;}
            }
            System.out.println("Llega "+ nombre );
        }
    }

    //Creamos los objetos Animal
    static Animal guepardo;
    static Animal liebre;
    static Animal tortuga;

    public static void main(String[] args) throws InterruptedException {


        guepardo = new Animal("Guepardo");
        guepardo.setPriority(Thread.MAX_PRIORITY);
        liebre 	= new Animal("Liebre");
        liebre.setPriority(Thread.NORM_PRIORITY);
        tortuga  = new Animal("Tortuga");
        tortuga.setPriority(Thread.MIN_PRIORITY);

        // ¡Comienza la carrera!
        guepardo.start();
        liebre.start();
        tortuga.start();

        // Main finaliza antes de que acabe la carrera
    }
}

