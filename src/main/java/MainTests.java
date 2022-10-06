import XML.xmltojson;

import java.io.File;

public class MainTests
{
    public static void main(String[] args)
    {
        String fileName = "C:\\Users\\Антон\\Desktop\\ФИб5\\Практика\\Задание 2\\FileConverterService\\"
                +"БольницаXML"+".xml";
        File file = new File(fileName);
        xmltojson parser = new xmltojson(file);
        parser.ParsingXMLtoJSON();
    }
}
