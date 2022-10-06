package Save;

import JSON.Hospital;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SaveXML
{
    private static final String FILENAME= "C:\\Users\\Антон\\Desktop\\ФИб5\\Практика\\Задание 2\\FileConverterService\\Новый.xml";
    public static void save(Hospital hosp)
    {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db  = null;
        Document doc = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db  = dbf.newDocumentBuilder();
            doc = db.newDocument();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i = 0; i < hosp.getPatients().size(); i++)
        {

        }
    }
}
