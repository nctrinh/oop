package EXPRESSION;

public class Square extends Expression{
    Expression expression;
    Square(Expression expression){
        this.expression = expression;
    }
    @Override
    public String toString() {
        return Integer.toString(this.evaluate());
    }
    @Override
    int evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
}
