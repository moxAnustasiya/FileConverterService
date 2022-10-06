package Save;

import XML.Hospital;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SaveJson
{
    private static final String FILENAME= "C:\\Users\\Антон\\Desktop\\ФИб5\\Практика\\Задание 2\\FileConverterService\\Пациент.json";

    public static void save(Hospital hosp)
    {
        JSONObject jsonHosp = new JSONObject();
        JSONObject jsonPatients = new JSONObject();
        JSONArray patients = new JSONArray();
        for (int i = 0; i < hosp.getDepartments().size(); i++)
        {
            for (int j = 0; j < hosp.get(i).getWard().size(); j++)
            {
                for (int y = 0; y < hosp.get(i,j).getPatients().size(); y++)
                {
                    JSONObject jsonPatient = new JSONObject();
                    JSONObject patient = new JSONObject();
                    patient.put("id",hosp.get(i,j,y).getId());
                    patient.put("name",hosp.get(i,j,y).getName());
                    patient.put("surname",hosp.get(i,j,y).getSurname());
                    patient.put("diagnosis",hosp.get(i,j,y).getDiagnosis());
                    patient.put("ward number",hosp.get(i,j).getNum());
                    patient.put("department",hosp.get(i).getTitle());
                    jsonPatient.put("Patient id = " + hosp.get(i,j,y).getId(), patient);
                    patients.add(jsonPatient);
                }
            }
        }
        jsonPatients.put("Patients", patients);
        jsonHosp.put("Hospital", jsonPatients);
        try (FileWriter writer = new FileWriter(FILENAME))
        {
            writer.write(jsonHosp.toJSONString());
            writer.flush();
        }
        catch (IOException ex)
        {
            Logger.getLogger(SaveJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
