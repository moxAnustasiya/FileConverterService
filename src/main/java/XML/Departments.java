package XML;

import java.util.List;

public class Departments
{
    protected List<Wards> ward;
    protected String title;
    public Departments(List<Wards> ward, String title)
    {
        this.ward = ward;
        this.title = title;
    }
    public List<Wards> getWard()
    {
        return ward;
    }
    public Wards get(int index) {return ward.get(index);}

    public String getTitle() {
        return title;
    }
}
