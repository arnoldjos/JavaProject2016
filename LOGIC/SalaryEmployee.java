package LOGIC;

public class SalaryEmployee extends Employee
{
    //ATTRIBUTE
    private double weeklysal;
    
    //CONSTRUCTOR
    public SalaryEmployee(int id,String fname, String lname, boolean flag, String job,double weeklysal)
    {
        super(id,fname,lname,job,flag);
        setWeeklysal(weeklysal);
    }
    
    //METHODS
    public void setWeeklysal(double weeklysal)
    {
         this.weeklysal=weeklysal;
    }
    
    public double getWeeklysal()
    {
        return weeklysal;
    }
   
}
