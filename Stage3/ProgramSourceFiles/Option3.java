import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Option3 {  
   //Register/edit new employee
   public static ArrayList<Employees> option3(Hotel hotel){

      boolean exit = false;
      Scanner scanner = new Scanner(System.in);  
            //Ask options. Keep trying until proper response is given
            do{
               try {
                     scanner = new Scanner(System.in);   
                     System.out.print("Please select option:\n\n1. Create new employee\n2. Flip employee employment status\n3. Cancel\n");
                     int roomTypeInt = scanner.nextInt();      
      
                     switch (roomTypeInt) 
                     {
                        case 1: exit=true; hotel.employeesArray = createEmployee(hotel); break;
                        case 2: exit=true; hotel.employeesArray = retireEmployee(hotel); break;
                        case 3: exit=true; System.out.println("No changes made."); return hotel.employeesArray;
                        default:System.out.println("Invalid option"); break;
                     }
                  } catch (InputMismatchException e) {
                  System.out.println("Please enter a valid numeric value.");
                  scanner.next();
               }
            }while(exit==false);
                  
            return hotel.employeesArray;

   }

   private static ArrayList<Employees> createEmployee(Hotel hotel){

      String empName = "";
      float hourlyWage = 0.0f;
      String jobTitle = "";
      boolean exit = false;
      String isManager = "";

      Scanner scanner = new Scanner(System.in); 
      
      //Ensure credentials are present prior to making updates to employees
      System.out.print("Please enter default admin password:");
      isManager = scanner.nextLine();

      if(!isManager.equals("root")){
         System.out.println("Wrong password. Returning to main menu.");
         return hotel.getEmployeesArray();
      }
      
      do{
         try {

               scanner = new Scanner(System.in); 
               System.out.println("Is new employee a manager?\nPlease enter Y for yes, N for no.");
               isManager = scanner.nextLine();
            
               System.out.print("Enter the new employee name: ");
               empName = scanner.nextLine();

               scanner = new Scanner(System.in); 
               System.out.print("Enter the salary: ");
               hourlyWage = scanner.nextFloat();
               
               scanner = new Scanner(System.in); 
               System.out.print("Enter the new employee job title: ");
               jobTitle = scanner.nextLine();
               
               exit = true;

            } catch (InputMismatchException e) {
            System.out.println("Please enter a valid value.");
            scanner.next();
         }
      }while(exit==false);

      //If manager, create a manager object
      Employees employees;
      if(isManager.equals("Y")){
         employees = new EmployeesManager(hourlyWage, empName, jobTitle, true);
      }else{
         employees = new Employees(hourlyWage, empName, jobTitle);         
      }

      //Add to employeeArray list
      hotel.employeesArray.add(employees);
      System.out.println("New employee created!");
      return hotel.getEmployeesArray();
   }

   private static ArrayList<Employees> retireEmployee(Hotel hotel){

      int empID = -1;
      boolean exit = false;
      Scanner scanner = new Scanner(System.in);  
      
      //Ask for details
      do{
         try {
            
               System.out.print("Enter the new employee ID to update: ");
               empID = scanner.nextInt();
               exit = true;

            } catch (InputMismatchException e) {
            System.out.println("Please enter a valid value.");
            scanner.next();
         }
      }while(exit==false);

      for (Employees employees : hotel.getEmployeesArray()) {
         
         if (employees.getEmpID() == empID) {
            //Flip employee active status
            employees.setActiveEmployee(!employees.isActiveEmployee());
            System.out.println("Employee status for " + employees.getName() + " updated to : " + employees.isActiveEmployee());
            return hotel.getEmployeesArray();
         }
      }

      System.out.println("Error, no changes made");
      return hotel.getEmployeesArray();
      
   }

}
