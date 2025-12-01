package stringCalculator;

import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Autowired
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void test1(){
        assertEquals(0, stringCalculator.add1(""));
        assertEquals(3, stringCalculator.add1("0,1,2"));
    }

    @Test
    public void test2(){
        assertEquals(5, stringCalculator.add2("1,1,1,2"));
        assertEquals(21, stringCalculator.add2("0,1,2,3,4,5,6"));
    }

    @Test
    public void test3(){
        assertEquals(6, stringCalculator.add3("1\n2,3"));
    }

    @Test
    public void test4(){
        assertEquals(3, stringCalculator.add4("//;\n1;2"));
        assertEquals(3, stringCalculator.add4("//:\n1:2"));
    }

    @Test
    public void test5() throws Exception {
//        assertEquals(0, stringCalculator.add5("-1,2"));
    }

    @Test
    public void test6() throws Exception {
        assertEquals(3, stringCalculator.add6("1001,3"));
    }

    @Test
    public void test7() throws Exception {
        assertEquals(6, stringCalculator.add7("//[|||]\n1|||2|||3"));
        assertEquals(6, stringCalculator.add7("//[||||]\n1||||2||||3"));
    }

    @Test
    public void test8() throws Exception {
        assertEquals(6, stringCalculator.add8("//[|][%]\n1|2%3"));
        assertEquals(3, stringCalculator.add8("0,1,2"));
    }

    @Test
    public void test9() throws Exception {
        assertEquals(6, stringCalculator.add9("//[||][%]\n1||2%3"));
    }
}
