package EXPRESSION;

public class Numeral implements Expression{
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
