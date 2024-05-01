package EXPRESSION;

public class Addition extends Expression {
    Expression left;
    Expression right;
    Addition(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return Integer.toString(this.evaluate());
    }
    @Override
    int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
