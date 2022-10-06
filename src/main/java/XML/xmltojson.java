package XML;

import Read.ReadXML;
import Save.SaveJson;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class xmltojson
{
    private static Document dom;
    private static Hospital hosp;
    public xmltojson(File file)
    {
        DocumentBuilderFactory doc = DocumentBuilderFactory.newInstance();
        try
        {
            dom = doc.newDocumentBuilder().parse(file);
        } catch (Exception e) {
            System.out.println("Open parsing error: " + e.toString());
            return;
        }
    }
    private static void Reading()
    {
       hosp = ReadXML.read(dom);
    }
    private static void Writing()
    {
        SaveJson.save(hosp);
    }
    public static void ParsingXMLtoJSON()
    {
        Reading();
        Writing();
    }
}
