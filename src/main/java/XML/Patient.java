package XML;

public class Patient
{
    protected String name;
    protected String surname;
    protected String diagnosis;
    protected String id;
    public Patient(String name, String surname, String diagnosis, String id)
    {
        this.name = name;
        this.surname = surname;
        this.diagnosis = diagnosis;
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
}
