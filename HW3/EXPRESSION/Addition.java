package EXPRESSION;

public class Addition implements BinaryExpression{
    
    Expression left;
    Expression right;

    Addition(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
    }
    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
    @Override
    public Expression left() {
        return left;
    }
    @Override
    public Expression right() {
        return right;
    }
}
