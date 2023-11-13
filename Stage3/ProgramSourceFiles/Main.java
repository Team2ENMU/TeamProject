/*
 * 1. Caleb Palmares
 */

public class Main {

   public static void main (String[] args) {

      //Generate new hotel object and assign random number of rooms between 10 and 50
      Hotel hotel = new Hotel(RandomValues.generateRandomNumber(10, 50));
            
      //Update hotel object rooms array with random values. Pass room count and current array
      hotel.roomsArray = RandomValues.assignGuestsToRooms(hotel.getNumRooms(), hotel.roomsArray);
      
      //Hard code 6 default employees to create
      Employees[] aEmployees = new Employees[6];
      aEmployees[0]  = new EmployeesManager(100.26f, "Zach Wilsom",  "Boss", true);
      aEmployees[5] = new Employees(20.20f, "Dak Prescott",  "Receptionist");
      aEmployees[1]  = new Employees(20.21f, "Josh Allen",  "Maintenance");
      aEmployees[2]  = new Employees(20.22f, "Kyler Murray",  "Maintenance");
      aEmployees[3]  = new Employees(30.30f, "Patrick Mahomes",  "Housekeeper");
      aEmployees[4]  = new Employees(30.35f, "Lamar Jackson",  "Housekeeper");
      
      //Loop through all employees. Add them to employees array
      for (Employees employee : aEmployees) {
         hotel.employeesArray.add(employee);         
      }

      //Call menu with hotel object
      Menu.menu(hotel);
      
   }
}
