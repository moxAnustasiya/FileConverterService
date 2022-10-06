package Read;

import JSON.Hospital;
import JSON.Patient;
import JSON.Patients;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ReadJSON
{
    public static Hospital read(JSONObject object)
    {
        Patients ps;
        Patient p;
        List<Patient>patientList = new ArrayList<>();
        JSONArray patients = (JSONArray) object.get("Patients");
        for (int i = 0; i < patients.size();i++)
        {
            JSONObject patient = (JSONObject) patients.get(i);
            p = new Patient((String)patient.get("name"), (String)patient.get("surname"),(String)patient.get("diagnosis"),(String)patient.get("ward"),(String)patient.get("department"), (String)patient.get("id"));
            patientList.add(p);
        }
        ps = new Patients(patientList);
        return new Hospital(ps);
    }
}
