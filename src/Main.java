import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String primo = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String tmpS;
        int tmp;
        ArrayList<Cavallo> listaCavallo = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            System.out.println("Inserisci il nome del cavallo " + i + ": ");
            tmpS = input.nextLine();
            System.out.println("Inserisci la lentezza del cavallo " + i + ": ");
            tmp = input.nextInt();
            input.nextLine();
            Cavallo c = new Cavallo(tmpS, tmp);
            listaCavallo.add(c);
        }

        for (Cavallo c : listaCavallo) {
            c.start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random rand = new Random();
        Cavallo sfortunato = listaCavallo.get(rand.nextInt(listaCavallo.size()));
        System.out.println("Il cavallo " + sfortunato.getNome() + " è stato azzoppato!");
        sfortunato.azzoppa();

        for (Cavallo c : listaCavallo) {
            try {
                c.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (primo.equals("")) {
            System.out.println("Nessun cavallo è arrivato al traguardo.");
        } else {
            System.out.println("Il primo cavallo arrivato è: " + primo);
        }
    }

    public static String getPrimo() {
        return primo;
    }

    public static void setPrimo(String primo) {
        Main.primo = primo;
    }
}
