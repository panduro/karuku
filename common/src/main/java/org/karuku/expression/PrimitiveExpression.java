package org.karuku.expression;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: panduro
 * Date: 8/9/13
 * Time: 8:11 AM
 */
@XmlRootElement
public class PrimitiveExpression extends Expression{
    @XmlType
    @XmlEnum
    public enum Modifier {PLUS, MINUS};

    public PrimitiveExpression(Modifier modifier, Long absoluteValue) {
        if(absoluteValue < 0) throw new IllegalArgumentException("Value should be a natural number. For negative integers, use " +
                "modifier = Modifier.MINUS or one-argument constructor.");
        this.absoluteValue = absoluteValue;
        this.modifier = modifier;
    }

    public PrimitiveExpression(Long value) {
        this(value < 0 ? Modifier.MINUS : Modifier.PLUS, Math.abs(value));
    }

    public PrimitiveExpression() {
    }

    @XmlElement
    public Modifier getModifier() {
        return modifier;
    }

    private Modifier modifier;

    private Long absoluteValue;

    @XmlElement
    public Long getAbsoluteValue() {
        return absoluteValue;
    }

    public Long getValue() {
        switch (modifier) {
            case PLUS:
                return absoluteValue;
            case MINUS:
                return -absoluteValue;
            default:
                throw new IllegalStateException("modifier not supported: " + modifier);
        }

    }

    @Override
    public String toString() {
        return getValue().toString();
    }

    @Override
    public PrimitiveExpression acceptEvaluator(Evaluator e) {
        return e.evaluate(this);
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    public void setAbsoluteValue(Long absoluteValue) {
        this.absoluteValue = absoluteValue;
    }
}
