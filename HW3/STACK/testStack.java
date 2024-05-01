package STACK;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testStack {

    @Test
    public void test1(){
        Stack<String> stack = new Stack<>();
        stack.push("hello world");
        String s = stack.pop();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void test2(){
        Stack<String> stack = new Stack<>();
        stack.push("hello world");
        String s = stack.pop();
        assertEquals("hello world", s);
    }


}
