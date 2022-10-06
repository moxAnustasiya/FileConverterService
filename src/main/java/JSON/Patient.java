package JSON;

public class Patient
{
    protected String name;
    protected String surname;
    protected String diagnosis;
    protected String ward;
    protected String department;
    protected String id;

    public Patient(String name, String surname, String diagnosis, String ward, String department, String id)
    {
        this.name = name;
        this.surname = surname;
        this.diagnosis = diagnosis;
        this.ward = ward;
        this.department = department;
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public String getDiagnosis()
    {
        return diagnosis;
    }
    public String getId() {
return id;
    }

    public String getWard() {
        return ward;
    }

    public String getDepartment() {
        return department;
    }
}
