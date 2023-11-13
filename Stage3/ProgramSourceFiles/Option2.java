import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Option2 {  
   //Register new guest
   public static Rooms[] option2(Hotel hotel){

   boolean exit = false;
   Scanner scanner = new Scanner(System.in);  

      do{
         try {
               scanner = new Scanner(System.in);   
               System.out.print("Please select option:\n\n1. Register guest\n2. Remove guest\n3. Cancel\n");
               int roomTypeInt = scanner.nextInt();      

               //Call method based on response from above
               switch (roomTypeInt) 
               {
                  case 1: exit=true; hotel.roomsArray = registerGuest(hotel); break;
                  case 2: exit=true; hotel.roomsArray = removeGuest(hotel); break;
                  case 3: exit=true; System.out.println("No changes made."); return hotel.getArray();
                  default:System.out.println("Invalid option"); break;
               }
            } catch (InputMismatchException e) {
            System.out.println("Please enter a valid numeric value.");
            scanner.next();
         }
      }while(exit==false);
            
      //Return updated array
      return hotel.getArray();
   
   }


   /**
    * @param hotel
    * @return
    */
   private static Rooms[] registerGuest(Hotel hotel){
      String guestName = "";
      String roomType = "";
      int startDate = -1;
      int endDate = -1;
      int guestID = -1;
      boolean bFoundGuestID = false;
      boolean exit = false;

      Scanner scanner = new Scanner(System.in);  
      
      //List all previous stays to help find guests
      Option5.option5(hotel);

      //Ask if user already exists
      exit = false;
      do{
         try {
               scanner = new Scanner(System.in);   
               System.out.print("\nIs guest a previous customer? If so, please enter Guest ID. If not, please enter 0: ");
               guestID = scanner.nextInt();                    
               exit = true;
               break;
            } catch (InputMismatchException e) {
            System.out.println("Please enter a valid numeric value.");
            scanner.next();
         }
      }while(exit==false);

      //If guest exists, then search for name and previous hotel type
      if(guestID>0){
         for (GuestArchive guest : hotel.guestHistoricStaysArray) {
            if(guest.getuserID() == guestID){
               guestName = guest.getGuestName();
               bFoundGuestID = true;
               System.out.println("NOTE: previous guest room type was a " + guest.getRoomType() + " room.");
               break;
            }
         }         
      }

      //If not found, ask for reservation name
      if(!bFoundGuestID){
         scanner = new Scanner(System.in);  
         System.out.print("Enter the reservation holder name: ");
         guestName = scanner.nextLine();         
      }

      //Ask for room type. Loop until proper selection is madee
      do{
         try {
               scanner = new Scanner(System.in);   
               System.out.print("Enter numeric value of room type:\n\n1. Standard\n2. Suite\n3. PentHouse\n");
               int roomTypeInt = scanner.nextInt(); 
               switch (roomTypeInt) 
               {
                  case 1: exit=true; roomType = "Standard"; break;
                  case 2: exit=true; roomType = "Suite"; break;
                  case 3: exit=true; roomType = "PentHouse"; break;
                  default:System.out.println("Invalid option"); break;
               }
            } catch (InputMismatchException e) {
            System.out.println("Please enter a valid numeric value.");
            scanner.next();
         }
      }while(exit==false);

      //Ask for check in/out date
      exit = false;
      do{
         try {
               scanner = new Scanner(System.in);   
               System.out.println("Enter desired check-in date in numeric format yyyyMMdd:\nNOTE: entering non-valid date will cause program to crash.");
               startDate = scanner.nextInt();   

               System.out.println("Enter desired check-out date in numeric format yyyyMMdd:\nNOTE: entering non-valid date will cause program to crash.");
               endDate = scanner.nextInt();   
               
               exit = true;

            } catch (InputMismatchException e) {
            System.out.println("Please enter a valid numeric value.");
            scanner.next();
         }
      }while(exit==false);

      //Create guest object based off found guestID
      Guest guest;
      if(bFoundGuestID){
         guest = new Guest(guestName, guestID);
      }else{
         guest = new Guest(guestName);
      }

      //Search if room available type
      int room = hotel.getAvailableRoom(roomType);

      if(room < 0){
         System.out.println("Sorry, no vacancy.");
      }else{
         
         //Assign roomArray with respective info
         hotel.roomsArray[room].setGuest(guest);
         hotel.roomsArray[room].setStartDate(startDate);
         hotel.roomsArray[room].setEndDate(endDate);

         System.out.println("Guest " + guestName + " has been created and added to " +  hotel.roomsArray[room].getRoomType() + " room " + hotel.roomsArray[room].getRoomID() + ". " 
         + hotel.roomsArray[room].getFeatures());
      }
      return hotel.getArray();
   }











   private static Rooms[] removeGuest(Hotel hotel){
      
      boolean exit = false;

      Scanner scanner = new Scanner(System.in);      

      Option1.option1(hotel);
      System.out.println("Please make a selection:\n1. Enter a Room Number to vacate\n2. Remove all deliquent guests\n3. Cancel");
      //guestName = scanner.nextLine();

      do{
         try {
               scanner = new Scanner(System.in);   
               int roomTypeInt = scanner.nextInt();      

               switch (roomTypeInt) 
               {
                  case 1: 
                     exit=true;
                        System.out.println("Please enter Room Number:");
                        roomTypeInt = scanner.nextInt();

                        for (int i = 0; i < hotel.getArray().length; i++) {
                           Rooms room = hotel.roomsArray[i]; 
                           if (room.getRoomID() == roomTypeInt) {


                              //Define the two date strings
                              String dateStr1 = String.valueOf(room.getEndDate());
                              String dateStr2 = String.valueOf(room.getStartDate());

                              //Parse the date strings into LocalDate objects
                              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                              LocalDate date1 = LocalDate.parse(dateStr1, formatter);
                              LocalDate date2 = LocalDate.parse(dateStr2, formatter);

                              //Calculate the difference between the two dates
                              long daysDifference = ChronoUnit.DAYS.between(date2, date1);

                              //Minimum of 1 day required
                              if(daysDifference == 0){
                                 daysDifference = 1;
                              }

                              //Print the difference
                              System.out.println("Guest " + room.getGuest().getGuestName() + " stayed for " + daysDifference + " days and is now checked-out.");
                              System.out.println("\tTotal cost of stay: " + daysDifference*room.getRoomCost());

                              GuestArchive guestArchive = new GuestArchive(room.getGuest().getGuestName(), room.getGuest().getuserID(), daysDifference, room.getRoomType());
                              hotel.guestHistoricStaysArray.add(guestArchive);
                              
                              room.setGuest(null);
                              room.setClean(false);
                              
                              return hotel.roomsArray;
                           }
                        }
                        System.out.println("Error with Room number: " + roomTypeInt + ". No changes made. Going back to main menu...");
                     break;
                  case 2: 
                     exit=true;

                        for (int i = 0; i < hotel.getArray().length; i++) {
                           Rooms room = hotel.roomsArray[i]; 

                           //No end date provided, so skip
                           if(room.getEndDate() < 0){
                              continue;
                           }

                           //Convert current day to and integer and compare end date
                           if (room.getEndDate() <= Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))) {
                              //Definee two date strings
                              String dateStr1 = String.valueOf(room.getEndDate());
                              String dateStr2 = String.valueOf(room.getStartDate());

                              //get date strings into local vars
                              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                              LocalDate date1 = LocalDate.parse(dateStr1, formatter);
                              LocalDate date2 = LocalDate.parse(dateStr2, formatter);

                              //Calculate the difference between the two dates
                              long daysDifference = ChronoUnit.DAYS.between(date2, date1);

                              //Minimum of 1 day required
                              if(daysDifference == 0){
                                 daysDifference = 1;
                              }

                              //Print the difference
                              System.out.println("Guest " + room.getGuest().getGuestName() + " stayed for " + daysDifference + " days and is now checked-out.");
                              System.out.println("\tTotal cost of stay: " + daysDifference*room.getRoomCost());

                              GuestArchive guestArchive = new GuestArchive(room.getGuest().getGuestName(), room.getGuest().getuserID(), daysDifference, room.getRoomType());
                              hotel.guestHistoricStaysArray.add(guestArchive);
                              
                              room.setGuest(null);
                              room.setStartDate(-1);
                              room.setEndDate(-1);
                              room.setClean(false);
                              
                           }
                        }
                        
                        return hotel.roomsArray;

                  case 3: exit=true; return hotel.getArray();
                  default:System.out.println("Invalid option"); break;
               }
            } catch (InputMismatchException e) {
            System.out.println("Please enter a valid numeric value.");
            scanner.next();
         }
      }while(exit==false);
      return hotel.getArray();
   }








}
