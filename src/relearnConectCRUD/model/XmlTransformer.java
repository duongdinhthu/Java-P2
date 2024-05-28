package relearnConectCRUD.model;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlTransformer {

    public static String transform(String xml, String xsl) throws TransformerException {
        Source xmlInput = new StreamSource(new StringReader(xml));
        Source xslInput = new StreamSource(new StringReader(xsl));

        StringWriter htmlOutput = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer(xslInput);
        transformer.transform(xmlInput, new StreamResult(htmlOutput));

        return htmlOutput.toString();
    }
}