package XML;

import java.util.List;

public class Wards
{
    protected List<Patient> patients;
    protected String num;
    public Wards(List<Patient> patients, String number) {
        this.patients = patients;
        num = number;
    }
    public List<Patient> getPatients()
    {
        return patients;
    }
    public Patient get(int index)
    {
        return patients.get(index);
    }

    public String getNum() {
        return num;
    }
}
