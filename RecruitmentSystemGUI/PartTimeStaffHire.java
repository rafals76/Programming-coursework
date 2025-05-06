/**
 * Write a description of class PartTimeStaffHire here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PartTimeStaffHire extends StaffHire
{
    // instance variables - replace the example below with your own
    private int workingHours;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    /**
     * Constructor for objects of class PartTimeStaffHire
     */
    public PartTimeStaffHire(int aVacancyNumber, String aDesignation, String aJobType,
                         String aStaffName, String aJoiningDate, String aQualification, 
                         String aAppointedBy, boolean aJoined, int aWorkingHours, 
                         double aWagesPerHour, String aShifts) 
{
    super(aVacancyNumber, aDesignation, aJobType, aStaffName, aJoiningDate, 
          aQualification, aAppointedBy, aJoined);
    
    this.workingHours = aWorkingHours;
    this.wagesPerHour = aWagesPerHour;
    this.shifts = aShifts;
    this.terminated = false;
}

    public int getWorkingHours()
    {
        return workingHours;
    }
   
    public void setWorkingHours(int newWorkingHours)
    {
        workingHours = newWorkingHours;
       
    }
   
    public double getWagesPerHour()
    {
        return wagesPerHour;
    }
   
    public void setWagesPerHour(double newWages)
    {
        wagesPerHour = newWages;
    }
   
    public String getShifts()
    {
        return shifts;
       
    }
   
    public void setShifts(String newShifts)
    {
        shifts = newShifts;
       
    }
   
    public boolean getTerminated()
    {
        return terminated;
       
    }
   
    public void setTerminated(boolean isTerminated)
    {
        terminated = isTerminated;
    }

    public void terminateStaff()
   
    {
        if (terminated == true)
        {
            System.out.println("Staff already termintaed !");
           
        }
        else
        {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            setTerminated(true);
        }
    }
   
    public void display()
    {
        super.display();
        if (getWorkingHours() !=0)
        {
            System.out.println("Wages per hour:" + wagesPerHour);
            System.out.println("Working hours:" + workingHours);
            System.out.println("Shifts:" + shifts);
            System.out.println("Terminated: " +(terminated ? "Yes" :"No"));
            System.out.println("Income Per day: £" + (workingHours * wagesPerHour));
        }
    }
}