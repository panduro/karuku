package org.karuku.expression;

/**
 * Created with IntelliJ IDEA.
 * User: panduro
 * Date: 8/9/13
 * Time: 1:32 PM
 */
public interface Evaluator {
    PrimitiveExpression evaluate(CompositeExpression e);
    PrimitiveExpression evaluate(PrimitiveExpression e);
}
