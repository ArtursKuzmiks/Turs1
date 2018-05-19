package sec;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class uzd5Test {


    @Test
    void main() throws IOException {
        String[] str1 = {"3 0 0 0","0 4 3 0",
                "0 2 1 0","0 0 0 2"};
        uzd5.main(str1);
        String[] str2 = {"0 2 0 3","0 0 1 0",
                "0 4 0 0","2 0 3 0"};
        uzd5.main(str2);
    }
}