package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uzd3 {
    public static void main(String[] args) throws IOException {

        int n, k, i;
        double x;
        String str;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Ievadiet majas augstums: ");
            str = br.readLine();
            n = Integer.parseInt(str);

            System.out.print("Petera stava augstums: ");
            str = br.readLine();
            k = Integer.parseInt(str);

            System.out.print("Ievadiet elastibas koeficientu: ");
            str = br.readLine();
            x = Math.rint(1000.0 * Double.parseDouble(str)) / 1000.0;

        } catch (IllegalArgumentException e) {
            System.out.println("input error");
            return;
        }

        i = 0;
        while (n > k) {
            n = (int) (n * x);
            i++;
        }
        if (i == 0) i = 0;
        else i = (i - 1) * 2 + 1;
        System.out.println("Peteris redzeja bumbu " + i + " reizes.");
    }
}
