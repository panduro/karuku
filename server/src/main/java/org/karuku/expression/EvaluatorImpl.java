package org.karuku.expression;

/**
 * Created with IntelliJ IDEA.
 * User: panduro
 * Date: 8/9/13
 * Time: 1:39 PM
 */
public class EvaluatorImpl implements Evaluator {

    @Override
    public PrimitiveExpression evaluate(CompositeExpression e) {
            Long firstValue = e.getFirstOperand().acceptEvaluator(this).getValue();
            Long secondValue = e.getSecondOperand().acceptEvaluator(this).getValue();

            switch (e.getOperation()) {
                case PLUS: return new PrimitiveExpression(firstValue + secondValue);
                case MINUS: return new PrimitiveExpression(firstValue - secondValue);
                case MULTIPLY: return new PrimitiveExpression(firstValue * secondValue);
                case DIVIDE: return new PrimitiveExpression(firstValue / secondValue);
                default: throw new UnsupportedOperationException("operation unsupported: " + e.getOperation());
            }
    }

    @Override
    public PrimitiveExpression evaluate(PrimitiveExpression e) {
        return e;
    }
}
