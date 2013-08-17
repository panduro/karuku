package org.karuku.expression;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: panduro
 * Date: 8/9/13
 * Time: 8:24 AM
 */
@XmlRootElement
public class CompositeExpression extends Expression {
    public CompositeExpression(Expression firstOperand, Expression secondOperand, Operation operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    public CompositeExpression() {
    }

    @XmlType
    @XmlEnum
    public static enum Operation {PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

        private final String representation;
         Operation(String representation) {
             this.representation = representation;
        }

        public String toString() {
            return representation;
        }
    };

    private Expression firstOperand;

    private Expression secondOperand;

    private Operation operation;

    @XmlElement
    public Expression getFirstOperand() {
        return firstOperand;
    }

    @XmlElement
    public Expression getSecondOperand() {
        return secondOperand;
    }

    @XmlElement
    public Operation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "(" + firstOperand + operation + secondOperand + ")";
    }

    @Override
    public PrimitiveExpression acceptEvaluator(Evaluator e) {
        return e.evaluate(this);
    }

    public void setFirstOperand(Expression firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(Expression secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}

