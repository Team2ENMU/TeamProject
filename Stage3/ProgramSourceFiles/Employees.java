public class Employees {
   
   private String name;
   private static int nextEmpID = 3001; //Start empID at 3001
   private int empID;
   private String jobTitle;
   private float hourlyWage;
   private boolean activeEmployee = true;

   //Contructor for passed variables. empID is automatically incremented
   public Employees(float hourlyWage, String name, String jobTitle){
      this.hourlyWage = hourlyWage;
      this.name = name;
      this.empID = nextEmpID++;
      this.jobTitle = jobTitle;
   }

   //Return if active employee
   public boolean isActiveEmployee() {
      return activeEmployee;
   }

   /**
    * @param activeEmployee status
    */
   public void setActiveEmployee(boolean activeEmployee) {
      this.activeEmployee = activeEmployee;
   }

   /**
    * @return wage
    */
   public double getHourlyWage() {
      return hourlyWage;
   }

   /**
    * @param hourlyWage set value
    */
   public void setHourlyWage(float hourlyWage) {
      this.hourlyWage = hourlyWage;
   }

   /**
    * @return name
    */
   public String getName() {
      return name;
   }

   /**
    * @param name set name
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * @return return empID
    */
   public int getEmpID() {
      return empID;
   }

   /**
    * @param empID
    */
   public void setEmpID(short empID) {
      this.empID = empID;
   }

   /**
    * @return jobTitle
    */
   public String getJobTitle() {
      return jobTitle;
   }

   /**
    * @param jobTitle setJobTitle
    */
   public void setJobTitle(String jobTitle) {
      this.jobTitle = jobTitle;
   } 


}
