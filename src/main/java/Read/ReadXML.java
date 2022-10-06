package Read;

import XML.Departments;
import XML.Hospital;
import XML.Patient;
import XML.Wards;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

public class ReadXML
{
    public static Hospital read(Document dom)
    {
        Node hospital = dom.getFirstChild();
        NodeList hospitalChild = hospital.getChildNodes();
        Node department = null;
        List<Departments> departmentsList = new ArrayList<>();
        for(int i = 0; i < hospitalChild.getLength(); i++)
        {
            if(hospitalChild.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            if(hospitalChild.item(i).getNodeName().equals("department")) department = hospitalChild.item(i);
            NodeList departmentChild = department.getChildNodes();
            Node ward = null;
            List<Wards> wardsList = new ArrayList<>();
            for(int j = 0; j < departmentChild.getLength(); j++)
            {
                if(departmentChild.item(j).getNodeType() != Node.ELEMENT_NODE) continue;
                if(departmentChild.item(j).getNodeName().equals("ward")) ward = departmentChild.item(j);
                NodeList wardChild = ward.getChildNodes();
                Node patient = null;
                List<Patient>patientList = new ArrayList<>();
                for(int y = 0; y < wardChild.getLength(); y++)
                {
                    if(wardChild.item(y).getNodeType() != Node.ELEMENT_NODE) continue;
                    if(wardChild.item(y).getNodeName().equals("patient")) patient = wardChild.item(y);
                    NodeList patientChild = patient.getChildNodes();
                    String name = "";
                    String surname= "";
                    String diagnosis= "";
                    for(int u = 0; u < patientChild.getLength(); u++)
                    {
                        if(patientChild.item(u).getNodeType() != Node.ELEMENT_NODE) continue;
                        switch (patientChild.item(u).getNodeName())
                        {
                            case "name":
                            {
                                name = patientChild.item(u).getTextContent();
                                break;
                            }
                            case "surname":
                            {
                                surname = patientChild.item(u).getTextContent();
                                break;
                            }
                            case "diagnosis":
                            {
                                diagnosis = patientChild.item(u).getTextContent();
                                break;
                            }
                        }
                    }
                    Patient p = new Patient(name,surname,diagnosis, patient.getAttributes().getNamedItem("id").getNodeValue());
                    patientList.add(p);
                }
                Wards patientsInWard = new Wards(patientList, ward.getAttributes().getNamedItem("number").getNodeValue());
                wardsList.add(patientsInWard);
            }
            Departments wardsInDepartment = new Departments(wardsList,department.getAttributes().getNamedItem("title").getNodeValue());
            departmentsList.add(wardsInDepartment);
        }
        return new Hospital(departmentsList);
    }
}
