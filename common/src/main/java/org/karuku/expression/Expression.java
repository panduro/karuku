package org.karuku.expression;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created with IntelliJ IDEA.
 * User: panduro
 * Date: 8/9/13
 * Time: 8:07 AM
 */
@XmlSeeAlso({PrimitiveExpression.class, CompositeExpression.class})
public abstract class Expression {
    public abstract PrimitiveExpression acceptEvaluator(Evaluator e);

    public Expression() {
    }
}
