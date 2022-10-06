package XML;

import java.util.List;

public class Hospital
{
    protected List<Departments> departments;
    public Hospital(List<Departments> departments)
    {
        this.departments = departments;
    }
    public List<Departments> getDepartments()
    {
        return departments;
    }
    public Departments get(int index)
    {
        return departments.get(index);
    }
    public Patient get(int i, int j, int y)
    {
        return departments.get(i).get(j).get(y);
    }
    public Wards get(int i, int j)
    {
        return departments.get(i).get(j);
    }
}
