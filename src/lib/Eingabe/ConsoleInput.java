package lib.Eingabe;
import java.util.Scanner;
public class ConsoleInput {
    public static String sInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("[Eingabe] Geben sie einen Text ein:");
        return s.next();
    }

    public static String sInput(String pM){
        Scanner s;
        while (true) {
            s = new Scanner(System.in);
            System.out.println("[Eingabe] " + pM);
            System.out.print("> ");
            try {
                return s.nextLine();
            }
            catch (Exception e) {
                System.out.println("{Error} Eingabe war ungueltig");
            }
        }
    }

    public static int iInput(){
        Scanner s;
        while (true) {
            s = new Scanner(System.in);
            System.out.println("[Eingabe] Geben sie eine ganze Zahl ein:");
            System.out.print("> ");
            try {
                return s.nextInt();
            }
            catch (Exception e) {
                System.out.println("{Error} Eingabe war ungueltig");
            }
        }
    }

    public static int iInput(String pM){
        Scanner s;
        while (true){
            s = new Scanner(System.in);
            System.out.println("[Eingabe] " + pM);
            System.out.print("> ");
            try {
                return s.nextInt();
            }
            catch (Exception e) {
                System.out.println("{Error} Eingabe war ungueltig");
            }
        }
    }

    public static double dInput(){
        Scanner s;
        while (true) {
            s = new Scanner(System.in);
            System.out.println("[Eingabe] Geben sie eine Zahl ein:");
            System.out.print("> ");
            try {
                return s.nextDouble();
            }
            catch (Exception e) {
                System.out.println("{Error} Eingabe war ungueltig. Ein Beispiel ist \"1,35\"");
            }
        }
    }

    public static double dInput(String pM){
        Scanner s;
        while (true){
            System.out.println("[Eingabe] " + pM);
            System.out.print("> ");
            s = new Scanner(System.in);
            try {
                return s.nextDouble();
            }
            catch (Exception e) {
                System.out.println("{Error} Eingabe war ungueltig. Ein Beispiel ist \"1,35\"");
            }
        }
    }
}