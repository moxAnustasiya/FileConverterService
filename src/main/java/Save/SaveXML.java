package Save;

import JSON.Hospital;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        catch (Exception e) {
            e.printStackTrace();
        }

        Element root = doc.createElement("Hospital");
        List<Element>departments = new ArrayList<>();
        List<Element>wards = new ArrayList<>();
        List<Element>patients = new ArrayList<>();

        HashMap<String, Element> mapWards= new HashMap<>();
        HashMap<String, Element> mapDepartments= new HashMap<>();

        for(int i = 0; i < hosp.getPatients().size(); i++)
        {
            Element patient = doc.createElement("patient");
            patient.setAttribute("id", hosp.get(i).getId());

            Element name = doc.createElement("name");
            name.appendChild((doc.createTextNode(hosp.get(i).getName())));

            Element surname = doc.createElement("surname");
            surname.appendChild((doc.createTextNode(hosp.get(i).getSurname())));

            Element diagnosis = doc.createElement("diagnosis");
            diagnosis.appendChild((doc.createTextNode(hosp.get(i).getDiagnosis())));

            Element department = doc.createElement("department");
            department.setAttribute("title", hosp.get(i).getDepartment());
            if(!mapDepartments.containsKey(hosp.get(i).getDepartment())) mapDepartments.put(hosp.get(i).getDepartment(), department);

            Element ward = doc.createElement("ward");
            ward.setAttribute("number", hosp.get(i).getWard());
            if(!mapWards.containsKey(hosp.get(i).getWard())) mapWards.put(hosp.get(i).getWard(), ward);

            patient.appendChild(name);
            patient.appendChild(surname);
            patient.appendChild(diagnosis);
            patients.add(patient);
            departments.add(department);
            wards.add(ward);
        }
        for (int i = 0; i < patients.size(); i++)
        {
            mapWards.get(wards.get(i).getAttribute("number")).appendChild(patients.get(i));
        }
        for (int i = 0; i < patients.size(); i++)
        {
            mapDepartments.get(departments.get(i).getAttribute("title")).appendChild(mapWards.get(wards.get(i).getAttribute("number")));
        }
        for (Element i:mapDepartments.values())
        {
            root.appendChild(i);
        }
        doc.appendChild(root);
        try (FileOutputStream output = new FileOutputStream(FILENAME))
        {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    private static void writeXml(Document doc, OutputStream output) throws TransformerException
    {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
    }
}
