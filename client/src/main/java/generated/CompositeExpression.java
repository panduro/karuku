
package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for compositeExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="compositeExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{}expression">
 *       &lt;sequence>
 *         &lt;element name="firstOperand" type="{}expression" minOccurs="0"/>
 *         &lt;element name="operation" type="{}operation" minOccurs="0"/>
 *         &lt;element name="secondOperand" type="{}expression" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compositeExpression", propOrder = {
    "firstOperand",
    "operation",
    "secondOperand"
})
@XmlRootElement
public class CompositeExpression
    extends Expression
{

    protected Expression firstOperand;
    protected Operation operation;
    protected Expression secondOperand;

    /**
     * Gets the value of the firstOperand property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getFirstOperand() {
        return firstOperand;
    }

    /**
     * Sets the value of the firstOperand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setFirstOperand(Expression value) {
        this.firstOperand = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link Operation }
     *     
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Operation }
     *     
     */
    public void setOperation(Operation value) {
        this.operation = value;
    }

    /**
     * Gets the value of the secondOperand property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getSecondOperand() {
        return secondOperand;
    }

    /**
     * Sets the value of the secondOperand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setSecondOperand(Expression value) {
        this.secondOperand = value;
    }

}
