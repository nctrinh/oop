package EXPRESSION;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestExpression {

    @Test
    public void test1(){
        
        Square one  = new Square(new Numeral(2));
        assertEquals(one.toString(), "4");
    }

}
