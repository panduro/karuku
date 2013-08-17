
package generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PrimitiveExpression_QNAME = new QName("", "primitiveExpression");
    private final static QName _CompositeExpression_QNAME = new QName("", "compositeExpression");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrimitiveExpression }
     * 
     */
    public PrimitiveExpression createPrimitiveExpression() {
        return new PrimitiveExpression();
    }

    /**
     * Create an instance of {@link CompositeExpression }
     * 
     */
    public CompositeExpression createCompositeExpression() {
        return new CompositeExpression();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimitiveExpression }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "primitiveExpression")
    public JAXBElement<PrimitiveExpression> createPrimitiveExpression(PrimitiveExpression value) {
        return new JAXBElement<PrimitiveExpression>(_PrimitiveExpression_QNAME, PrimitiveExpression.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeExpression }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "compositeExpression")
    public JAXBElement<CompositeExpression> createCompositeExpression(CompositeExpression value) {
        return new JAXBElement<CompositeExpression>(_CompositeExpression_QNAME, CompositeExpression.class, null, value);
    }

}
