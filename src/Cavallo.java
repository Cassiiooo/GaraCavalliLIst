import com.sun.tools.javac.Main;

public class Cavallo extends Thread {
    private final String name;
    private int lentezza;
    private boolean azzoppato = false;

    public Cavallo(String name, int lentezza) {
        super();
        this.name = name;
        this.lentezza = lentezza;
    }

    @Override
    public void run() {
        System.out.println("Cavallo " + name + " comincia il suo galoppo.");

        for (int i = 1; i <= 10; i++) {
            if (azzoppato) {
                System.out.println("Cavallo " + name + " è stato azzoppato e si ritira dalla gara.");
                return;
            }
            try {
                sleep(lentezza);
            } catch (InterruptedException a) {
                System.out.println("Cavallo " + name + " è stato fermato.");
                return;
            }

            System.out.println(name + " cavalca - passo: " + i);

            if (i == 10 && Main.getPrimo().equals("")) {
                Main.setPrimo(name);
            }
        }
    }

    public void azzoppa() {
        this.azzoppato = true;
        this.interrupt();
    }

    protected int getLentezza() {
        return lentezza;
    }

    protected void setLentezza(int lentezza) {
        this.lentezza = lentezza;
    }

    public String getNome() {
        return name;
    }
}
