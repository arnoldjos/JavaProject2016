package LOGIC;

import java.util.*;


public class Employee extends Calculate
{
    //ATTRIBUTES
    
    private String fname;
    private String lname;
    private String job;
    private boolean flag;
    private int id;
    
    //CONSTRUCTOR
    public Employee(int id,String fname, String lname, String job, boolean flag)
    {
        setId(id);
        setFname(fname);
        setLname(lname);
        setJob(job);
        setFlag(flag);
    }
    
    //METHODS
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setFname(String fname)
    {
        if(fname!=null||"".equals(fname))
        {
            this.fname=fname;
        }
    }
    
    public void setLname(String lname)
    {
        if(lname!=null||"".equals(lname))
        {
            this.lname=lname;
        }
    }
    
    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    
    public void setJob(String job)
    {
        if(job!=null||"".equals(job))
        {
            this.job=job;
        }
    }
    
    public int getId()
    {
        //String ids = String.valueOf(id);
        return id;
    }
    
    public String getFname()
    {
        return fname;
    }
    
    public String getLname()
    {
        return lname;
    }
    
    public boolean getFlag()
    {
        return flag;
    }
    
    public String getJob()
    {
        return job;
    }
    
    public void calculateWeeklyPay()
    {
        
    }

    public static Comparator<Employee> EmpNameComparator = new Comparator<Employee>() 
    {

    public int compare(Employee p1, Employee p2) {
       String emp1 = p1.getLname();
       String emp2 = p2.getLname();
       //ascending order
       int res = emp1.compareToIgnoreCase(emp2);
       if(res == 0)
       {
           String emp3 = p1.getFname();
           String emp4 = p2.getFname();
           return emp3.compareToIgnoreCase(emp4);
        }
       else
        return res;
    }};
}
