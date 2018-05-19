package sec;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class uzd4Test {

    @Test
    void main() throws IOException {
        String [] str1 = {"dedakadr"};
        uzd4.main(str1);
        String[] str2 = {"kualauals"};
        uzd4.main(str2);
        String[] str3 = {"asdfer"};
        uzd4.main(str3);
    }
}