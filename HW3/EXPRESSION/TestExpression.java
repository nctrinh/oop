package EXPRESSION;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestExpression {

    @Test
    public void test1(){
        
        Square one  = new Square(new Numeral(2));
        Numeral two = new Numeral(2);
        Addition ans = new Addition(one, two);
        assertEquals(ans.toString(), "2^2 + 2");
        
    }

}
