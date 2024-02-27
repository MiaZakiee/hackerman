import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        int len = password.length();
        Thread[] thread = new Thread [26];

        char startLetter = 'a';
        for (int i = 0; i < 26; i++) {
            thread[i] = new Thread(new CrackerRunnable(startLetter,password));
            startLetter = (char) (startLetter + 1);
        }

        for (Thread i : thread) {
            i.start();
//            try {
//                i.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }

    }
}