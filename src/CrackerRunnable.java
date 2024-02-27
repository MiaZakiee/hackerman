public class CrackerRunnable implements Runnable {
    char start;
    String pass;
    static boolean isFound = false;
    public CrackerRunnable(char start, String pass) {
        this.start = start;
        this.pass = pass;

    }

    @Override
    public void run() {
        // from ch+"aaaaa..." until ch+"zzzzz..."
        // example: pass = cool, ch = j
        // this thread searches jaaa to jzzz
//        System.out.println(start);
        int pLen = pass.length();
        String attackBuffer = start + "";
        String attack = attackBuffer.repeat(pLen);

        while (!attack.equals(pass) && !isFound) {
            System.out.println(attack);
            int i;
            for (i = pLen - 1; attack.charAt(i) == 'z'; i--);
            String first = attack.substring(0,i);
            char next = (char) (attack.charAt(i) + 1);
            String after = "a".repeat(pLen-i-1);
            attack = first + next + after;
            if (attack.equals(pass)) {
                System.out.println("Found: " + attack);
                isFound = true;
            }
        }
    }
}

//        String attack = "a".repeat(len);
//        while (!attack.equals(password)) {
//            System.out.println(attack);
//            int i;
//            for (i = len - 1; attack.charAt(i) == 'z'; i--);
//                String first = attack.substring(0,i);
//                char next = (char) (attack.charAt(i) + 1);
//                String after = "a".repeat(len-i-1);
//                attack = first + next + after;
//        }
//        System.out.println("Found: " + attack);