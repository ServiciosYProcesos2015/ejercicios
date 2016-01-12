public class CountThreadTest extends Thread {
    int from; //
    int to; //
    public CountThreadTest(int from, int to) { //
        this.from = from;
        this.to = to;
    }

    public void run() {
        for (int i=from; i<to; i++) {
            System.out.println(toString() + " i : " + i);
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) { //
            CountThreadTest t = new CountThreadTest(i*10,(i+1)*10);
            t.start(); // start invoca a run de CountThreadTest
        }
    }
}
