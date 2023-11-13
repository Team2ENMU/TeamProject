import java.util.InputMismatchException;
import java.util.Scanner;

public class Option7 {
   

   //Flip clean status
   public static Rooms[] option7(Hotel hotel){

      //Display list of unclean rooms to help user
      hotel.getUncleanRooms();

      boolean exit = false;
      boolean roomUpdated = false;
      Scanner scanner = new Scanner(System.in);  
      //Ask user which room to update
      do{
         try {
               scanner = new Scanner(System.in);   
               System.out.print("Please submit room number to update: ");
               int roomTypeInt = scanner.nextInt();      

               for (int i = 0; i < hotel.getArray().length; i++) {
                  Rooms room = hotel.roomsArray[i]; 
                  //If room number matches, then flip status
                  if (room.getRoomID() == roomTypeInt) {
                     room.setClean(!room.isClean());
                     System.out.println("Room " + roomTypeInt + " updated.");
                     roomUpdated = true;
                     break;
                  }
               }
               exit = true;
            
               if(!roomUpdated){
                  System.out.println("No changes made.");                  
               }

            
            } catch (InputMismatchException e) {
            System.out.println("Please enter a valid numeric value.");
            scanner.next();
         }
      }while(exit==false);
            
      return hotel.getArray();
   
   }


}
