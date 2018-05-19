package sec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class uzd3 {
    public static void main(String[] args) throws IOException {

        int count;
        String[] product;
        boolean found = false;


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Product count: ");
            count = Integer.parseInt(br.readLine());
            //count = Integer.parseInt(args[0]);  //jUnit test

            product = new String[count];

            for (int i = 0; i < count; i++) {
                System.out.print("Product " + (i + 1) + " : ");
                product[i] = br.readLine();
                //product[i] = args[i+1]; //jUnit test
                if (!product[i].matches("^[a-z]+"))
                    throw new IllegalArgumentException();
            }

            for (String i : product) {
                for (int n = 0; n < i.length() - 2; n++) {
                    int num = i.charAt(n);
                    if (num == i.charAt(n + 2) &&
                            i.charAt(n + 1) == num + 1) {
                        System.out.println(i);
                        found = true;
                    }
                }

            }

            if (!found) System.out.println("-1");

        } catch (IllegalArgumentException e) {
            System.out.println("Input error");
        }
    }
}
