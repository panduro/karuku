
package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for primitiveExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="primitiveExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{}expression">
 *       &lt;sequence>
 *         &lt;element name="absoluteValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="modifier" type="{}modifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "primitiveExpression", propOrder = {
    "absoluteValue",
    "modifier"
})
public class PrimitiveExpression
    extends Expression
{

    protected Long absoluteValue;
    protected Modifier modifier;

    /**
     * Gets the value of the absoluteValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAbsoluteValue() {
        return absoluteValue;
    }

    /**
     * Sets the value of the absoluteValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAbsoluteValue(Long value) {
        this.absoluteValue = value;
    }

    /**
     * Gets the value of the modifier property.
     * 
     * @return
     *     possible object is
     *     {@link Modifier }
     *     
     */
    public Modifier getModifier() {
        return modifier;
    }

    /**
     * Sets the value of the modifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Modifier }
     *     
     */
    public void setModifier(Modifier value) {
        this.modifier = value;
    }

}
