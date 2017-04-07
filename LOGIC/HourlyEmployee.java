package LOGIC;

import java.util.Comparator;

public class HourlyEmployee extends Employee
{
    //ATTRIBUTE
    
    private double payrate;
    private double hrs;
    private double weeklypay;
    
    //CONSTRUCTOR
    public HourlyEmployee(int id,String fname,String lname, boolean flag, String job,double payrate,double hrs)
    {
        super(id,fname,lname,job,flag);
        setPayrate(payrate);
        setHrs(hrs);
        calculateWeeklyPay();
    }
    
    
    //METHODs
    public void setPayrate(double payrate)
    {
        this.payrate=payrate;
    }
    
    public void setHrs(double hrs)
    {
        this.hrs=hrs;
    }
    
    public double getPayrate()
    {
        return payrate;
    }
    
    public double getHrs()
    {
        return hrs;
    }
    
    public String toString()
    {
           return super.toString()+" Weekly Salary:"+weeklypay;
    }
  
    public void calculateWeeklyPay()
    {
        weeklypay = payrate*hrs;
    }
    
    public double getWeeklyPay()
    {
        return weeklypay;
    }
    
    
}
