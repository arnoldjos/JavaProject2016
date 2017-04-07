package LOGIC;

import java.util.*;

public class EmployeeList
{
    private ArrayList<Employee> employeelist;
    private ArrayList<HourlyEmployee> hourlylist;
    private ArrayList<SalaryEmployee> salarylist;
    private int id=1;
    
    public EmployeeList()
    {
        employeelist = new ArrayList<Employee>();
        hourlylist = new ArrayList<HourlyEmployee>();
        salarylist = new ArrayList<SalaryEmployee>();
    }
    
    public ArrayList getEmployeeList()
    {
        return employeelist;
    }
    public ArrayList getHourlyList()
    {
        return hourlylist;
    }
    public ArrayList getSalaryList()
    {
        return salarylist;
    }
    
    public void addHourly(String fn, String ln, String job, String payrate, String hrs)
    {
        double rate = Double.parseDouble(payrate);
        double hr = Double.parseDouble(hrs);
        HourlyEmployee emp = new HourlyEmployee(id,fn,ln,true,job,rate,hr);
        employeelist.add(emp);
        hourlylist.add(emp);
        Collections.sort(employeelist, Employee.EmpNameComparator);
        id++;
    }
    
    public void addSalary(String fn, String ln, String job, String weeklysal)
    {
        double weekly = Double.parseDouble(weeklysal);
        SalaryEmployee emp = new SalaryEmployee(id,fn,ln,false,job,weekly);
        employeelist.add(emp);
        salarylist.add(emp);
        Collections.sort(employeelist, Employee.EmpNameComparator);
        id++;
    }
    
    public boolean edit(int id, String fn, String ln, String job)
    {
        int res = searchId(id);
        Employee temp;
        if(res != 0)
        {
            employeelist.get(res-1).setFname(fn);
            employeelist.get(res-1).setLname(ln);
            employeelist.get(res-1).setJob(job);
            Collections.sort(employeelist, Employee.EmpNameComparator);
            return true;
        }
        return false;
    }
    
    public boolean delete(int id)
    {
        int res = searchId(id);
        int res2 = searchIdHourly(id);
        int res3 = searchIdWeekly(id);
        if(res != 0)
        {
            
            if(flagChecker(res-1))
            {
                if(res2 != 0)
                    hourlylist.remove(res2-1);
            }
            else
            {
                if(res3!=0)
                    salarylist.remove(res3-1);
            }
            employeelist.remove(res-1);
            return true;
        }
        return false;
    }
    
    public String displayBox(int ctr)
    {
        String temp="";
        temp += employeelist.get(ctr).getId()+" - "+employeelist.get(ctr).getFname()+" "+employeelist.get(ctr).getLname();
        return temp;
    }
    
    public String forFname(int ctr)
    {
        int res=searchId(ctr);
        return employeelist.get(res-1).getFname();
    }
    public String forLname(int ctr)
    {
        int res=searchId(ctr);
        return employeelist.get(res-1).getLname();
    }
    public String forJobTitle(int ctr)
    {
        int res=searchId(ctr);
        return employeelist.get(res-1).getJob();
    }
    public String forEtype(int ctr)
    {
        int res=searchId(ctr);
        if(employeelist.get(res-1).getFlag())
            return "Hourly Employee";
        else
            return "Salary Employee";
    }
    public String childId(int ctr)
    {
        String tempid = String.valueOf(employeelist.get(ctr).getId());
        return tempid;
    }
    public String childFname(int ctr)
    {
        return employeelist.get(ctr).getFname();
    }
    public String childLname(int ctr)
    {
        return employeelist.get(ctr).getLname();
    }
    public String childJob(int ctr)
    {
        return employeelist.get(ctr).getJob();
    }
    public String childType(int ctr)
    {
        if(employeelist.get(ctr).getFlag())
            return "Hourly Employee";
        else
            return "Salary Employee";
    }
    public String childIdHourly(int ctr)
    {
        String tempid = String.valueOf(hourlylist.get(ctr).getId());
        return tempid;
    }
    public String childFnameHourly(int ctr)
    {
        return hourlylist.get(ctr).getFname();
    }
    public String childLnameHourly(int ctr)
    {
        return hourlylist.get(ctr).getLname();
    }
    public String childJobHourly(int ctr)
    {
        return hourlylist.get(ctr).getJob();
    }
    public String childPayHourly(int ctr)
    {
        String temppay = String.valueOf(hourlylist.get(ctr).getWeeklyPay());
        return temppay;
    }
    public String childIdWeekly(int ctr)
    {
        String tempid = String.valueOf(salarylist.get(ctr).getId());
        return tempid;
    }
    public String childFnameWeekly(int ctr)
    {
        return salarylist.get(ctr).getFname();
    }
    public String childLnameWeekly(int ctr)
    {
        return salarylist.get(ctr).getLname();
    }
    public String childJobWeekly(int ctr)
    {
        return salarylist.get(ctr).getJob();
    }    
    public String childPayWeekly(int ctr)
    {
         String temppay = String.valueOf(salarylist.get(ctr).getWeeklysal());
         return temppay;
    }

    public boolean flagChecker(int loc)
    {
        if(employeelist.get(loc).getFlag())
            return true;
        else
            return false;
    }
    
    public int searchId(int id)
    {
        for(int ctr=0;ctr<employeelist.size();ctr++)
        {
            if(employeelist.get(ctr).getId() == id)
            {
                return ctr+1;
            }
        }
        return 0;
    }
    public int searchIdHourly(int idd)
    {
        for(int ctr=0;ctr<hourlylist.size();ctr++)
        {
            if(hourlylist.get(ctr).getId() == idd)
            {
                return ctr+1;
            }
        }
        return 0;
    }
    public int searchIdWeekly(int idd)
    {
        for(int ctr=0;ctr<salarylist.size();ctr++)
        {
            if(salarylist.get(ctr).getId() == idd)
            {
                return ctr+1;
            }
        }
        return 0;
    }
  
}