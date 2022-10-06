import XML.xmltojson;

import java.io.File;
import java.util.Scanner;

public class MainTests
{
    public static void main(String[] args)
    {
        System.out.println("Введите имя файла с расширением xml: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        String fileName = "C:\\Users\\Антон\\Desktop\\ФИб5\\Практика\\Задание 2\\FileConverterService\\"
                +name+".xml";
        File file = new File(fileName);
        xmltojson parser = new xmltojson(file);
        parser.ParsingXMLtoJSON();
    }
}
