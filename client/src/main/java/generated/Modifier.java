
package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for modifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="modifier">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PLUS"/>
 *     &lt;enumeration value="MINUS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "modifier")
@XmlEnum
public enum Modifier {

    PLUS,
    MINUS;

    public String value() {
        return name();
    }

    public static Modifier fromValue(String v) {
        return valueOf(v);
    }

}
