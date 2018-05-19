package sec;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class uzd2Test {

    @Test
    void main() throws IOException {
        String [] str1 = {"3x3","7","3;3;3","4;3;5","3;6;3"};
        uzd2.main(str1);
        String[] str2 = {"3x4","4","4;2;2;2","2;2;2;2","2;2;2;2"};
        uzd2.main(str2);
    }
}