package EXPRESSION;

public class Numeral extends Expression{
    private int value;
    Numeral(int data){
        this.value = data;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }
    @Override 
    public int evaluate() {
        return value;       
    }
}
