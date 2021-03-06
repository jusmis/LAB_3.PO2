import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

class Main {
    static void TryAgain(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Czy chcesz spróbować ponownie?");
        String yn = scan.nextLine();
        if(yn.equals("yes")) {
            final int max = 101;
            int number=Game(max);
            int tries = 0;
            Guess(number,tries);
        } else if (yn.equals("no")) {
            System.exit(0);
        } else {
            System.out.println("Wpisz yes albo no");
            TryAgain();
        }

    }

    static int Game(int max){
        Random rand = new Random();
        int number = rand.nextInt(max);
        System.out.println("Wytypuj liczbę z przedziału od 0 do 100: ");
        return number;
    }

    public static void Guess(int number, int tries) {
        try {
            Scanner scan = new Scanner(System.in);
            int ans = scan.nextInt();
            if (ans > 100 || ans < 0) {
                System.out.println("Wprowadzona liczba nie miesici się w przedziale");
                Guess(number, tries);
            }
            if (ans != number) {
                if (ans < number) {
                    System.out.println("Wylosowana liczba jest większa");
                    tries++;
                    Guess(number,tries);
                } else {
                    System.out.println("Wylosowana liczba jest mniejsza");
                    tries++;
                    Guess(number,tries);
                }
            } else {
                tries++;
                System.out.println("Brawo!");
                System.out.println("Próbowałeś " + tries + " razy");
                TryAgain();
            }
        } catch (InputMismatchException e) {
            System.out.println("Wproadz liczbe");
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args){
        final int max = 101;
        System.out.println("Zostanie wylosowana liczba z przedziału od 0 do 100");
        int number = Game(max);
        int tries = 0;
        Guess(number, tries);
    }
}
