package sec;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class uzd1Test {

    @org.junit.jupiter.api.Test
    void main() throws IOException {
        String [] str1 = {"3","4/7","3/8","7/5"};
        uzd1.main(str1);
        String[] str2 = {"4","5/6","3/7","2/5","8/3"};
        uzd1.main(str2);


    }
}