

public class CarreraJusta {

    static class Pistola {
        boolean haDisparado = false;

        public void PUM(){
            haDisparado = true;
        }
        public boolean disparada(){
            return haDisparado;
        }
    }

    static class Animal extends Thread {
        String nombre;
        Pistola pistola;

        public Animal(String nombre, Pistola pistola) {
            this.nombre = nombre;
            this.pistola = pistola;
        }

        public void run() {
            // Esperamos el pistoletazo de salida
            synchronized(pistola){
                while(!pistola.disparada()){
                    try {
                        pistola.wait();
                    }catch (InterruptedException e){break;}
                }
            }
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

        Pistola pistola = new Pistola();

        guepardo = new Animal("Guepardo", pistola);
        guepardo.setPriority(Thread.MAX_PRIORITY);
        liebre 	= new Animal("Liebre", pistola);
        liebre.setPriority(Thread.NORM_PRIORITY);
        tortuga  = new Animal("Tortuga",pistola);
        tortuga.setPriority(Thread.MIN_PRIORITY);

        // Todos se quedarán quietos esperando la pistola
        guepardo.start();
        liebre.start();
        tortuga.start();

        System.out.println("¡Comienza la carrera!");
        pistola.PUM();
        synchronized(pistola){
            pistola.notifyAll();
        }

        // Main finaliza antes de que acabe la carrera
    }
}

