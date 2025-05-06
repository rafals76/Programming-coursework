
/**
 * Write a description of class staffhire here.
 *
 * @author (rafal skowron)
 * @version (a version number or a date)
 */
public class StaffHire
// instance variables - replace the example below with yourpublic class StaffHire
{
    private int vacancyNumber;
    private String designation;
    private String jobType;
    private String staffName;// First name, last name
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

     
    public StaffHire(int VacancyNumber,String Designation,String JobType,String StaffName,String JoiningDate,String Qualification, String AppointedBy, boolean Joined){
        this.vacancyNumber = VacancyNumber;
        this.designation = Designation;
        this.jobType = JobType;
        this.staffName = StaffName;
        this.joiningDate = JoiningDate;
        this.qualification = Qualification;
        this.appointedBy = AppointedBy;
        this.joined = Joined;
    }

    public int getVacancyNumber() 
    {
        return vacancyNumber;
    }

    public void setVacancyNumber(int newNumber)
    {

        vacancyNumber = newNumber;
    }

    public String getDesignation()
    {
        return designation;
    } 

    public void setdesignation(String newDesignation)
    {
        designation = newDesignation;
    }

    public String getjobType()
    {
        return jobType;
    }

    public void setJobType(String newJobType)
    {
        jobType = newJobType;
    }

    public String getStaffName()
    {
        return staffName;
    }

    public void setStaffName(String newStaffName)
    {
        staffName = newStaffName;
    }

    public String getJoiningDate()
    {
        return joiningDate;
    }

    public void setJoiningDate(String newJoiningDate)
    {
        joiningDate = newJoiningDate;
    }

    public String getQualification()
    {
        return qualification;
    }

    public void setQualification(String newQualification)
    {
        qualification = newQualification;
    }

    public String getAppointedBy()
    {
        return appointedBy;
    }

    public void setAppointedBy(String newAppointedBy)
    {
        appointedBy = newAppointedBy;
    }

    public boolean getJoined()
    {
        return joined;
    }

    public void setJoined(boolean newJoined)
    {
        joined = newJoined;
    }

    public void display()
    {System.out.println("vacancyNumber int is: "+vacancyNumber);
        System.out.println("designation String is: "+designation);
        System.out.println("jobType String is: "+ jobType);
        System.out.println("staffName String is:"+staffName);
        System.out.println("joiningDate String is:"+joiningDate);
        System.out.println("qualification String is:"+qualification);
        System.out.println("appointedBy String is:"+appointedBy);
        System.out.println("joined boolean is:"+joined);};
}

    
