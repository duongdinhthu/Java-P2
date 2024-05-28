import net.sf.saxon.TransformerFactoryImpl;
import net.sf.saxon.s9api.*;

import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XMLtoHTMLConverter {
    public static void main(String[] args) {
        try {
            Processor proc = new Processor(false);
            XsltCompiler comp = proc.newXsltCompiler();
            XsltExecutable exp = comp.compile(new StreamSource(new File("style.xsl")));
            XsltTransformer trans = exp.load();

            trans.setSource(new StreamSource(new File("product.xml")));
            Serializer out = proc.newSerializer(new File("output.html"));
            trans.setDestination(out);

            trans.transform();
            out.close();
        } catch (SaxonApiException e) {
            e.printStackTrace();
        }
    }
}