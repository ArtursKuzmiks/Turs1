package sec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class uzd4 {

    public static void main(String[] args) {

        String str;
        String temp = "";
        ArrayList<String> array = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Input string: ");
            str = br.readLine();
            //str = args[0];  //jUnit test

            if (!str.matches("^[a-z]+"))
                throw new IllegalArgumentException();

            for (int i = 0; i <= str.length(); i++) {
                for (int j = i; j < str.length(); j++) {
                    String string = str.substring(i,j+1);
                    if (checkPal(string) && string.length() > 2) {
                        if (!temp.contains(string)) {
                            temp = string;
                            array.add(temp);
                            found = true;
                        }
                    }
                }
            }

            if (!found) System.out.println("-1");
            else {

                array.sort((s1, s2) -> {
                    int rez = s1.length() - s2.length();
                    if (rez == 0) rez = s1.compareTo(s2);
                    else return rez;

                    return rez;
                });

                for (String counter : array) {
                    System.out.println(counter);
                }
            }

        } catch (IOException e) {
            System.out.println("Error");
        } catch (IllegalArgumentException el) {
            System.out.println("Input error");
        }
    }

    private static boolean checkPal(String str) {
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

}
