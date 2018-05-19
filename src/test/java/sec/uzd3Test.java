package sec;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class uzd3Test {

    @Test
    void main() throws IOException {
        String [] str1 = {"4","dwibuioweg","qnpptnecrprot",
                "opibweqghg","ioqugwfoqwf"};
        uzd3.main(str1);
        String[] str2 = {"2","asdfdeg","kjfasa"};
        uzd3.main(str2);
    }
}