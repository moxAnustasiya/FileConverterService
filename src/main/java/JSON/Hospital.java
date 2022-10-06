package JSON;

import java.util.List;

public class Hospital
{
    static Patients patients;

    public Hospital(Patients patients)
    {
        this.patients = patients;
    }
    public static List<Patient> getPatients()
    {
        return patients.patients;
    }
    public static Patient get (int i)
    {
        return patients.patients.get(i);
    }
}
