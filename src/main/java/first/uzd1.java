package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class uzd1 {
    // are string not number
    private static boolean noInteger(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static void main(String[] args) throws IOException {

        // TODO || atras unikalo telef. numuru skaitu no ievatitiem

        String[] num;
        String x;
        int n, m;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Ievadiet numuru skaitu: ");
            x = br.readLine();
            n = Integer.parseInt(x);
            if (n <= 0) throw new IllegalArgumentException();

            num = new String[n];

            System.out.println("Ievadiet numurus");

            for (int i = 0; i < n; i++)
                num[i] = br.readLine();

        } catch (IllegalArgumentException e) {
            System.out.println("input-error");
            return;
        }
        // atdalam kopijas
        String[] res = new HashSet<>(Arrays.asList(num)).toArray(new String[0]);
        m = n = res.length;

        for (int i = 0; i < n; i++) {
            if (res[i].length() != 8 || String.valueOf(res[i].charAt(0)).equals("0") || noInteger(res[i])) m--;
        }

        System.out.println("Unikalu numuru skaits: " + m);
    }
}
