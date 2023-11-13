public class EmployeesManager extends Employees{

   private boolean isAdmin;

   //Contructor
   public EmployeesManager(float hourlyWage, String name, String jobTitle, boolean isAdmin) {
      // Call parent
      super(hourlyWage, name, jobTitle);
      this.isAdmin = isAdmin;
   }

   /**
    * @return ifAdmin
    */
   public boolean isAdmin() {
      return isAdmin;
   }

   /**
    * @param isAdmin "Set admin"
    */
   public void setAdmin(boolean isAdmin) {
      this.isAdmin = isAdmin;
   }

   @Override
   //Overridden method that notates admin rights for manager
   public String getJobTitle() {
      return super.getJobTitle() + "\n\tHas admin privileges\n\t";
   }
   



}
