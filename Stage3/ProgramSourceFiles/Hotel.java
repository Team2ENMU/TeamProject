import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel{

   public Rooms[] roomsArray;
   public ArrayList<Employees> employeesArray;
   public ArrayList<GuestArchive> guestHistoricStaysArray;

   public Hotel(int numberofRooms){

      //Initialize
      roomsArray = new Rooms[numberofRooms];
      employeesArray = new ArrayList<>();
      guestHistoricStaysArray = new ArrayList<>();

      String numberofRoomsString = Integer.toString(numberofRooms);
      //Get first integer to determine number of floors
      int numberofFloors = Character.getNumericValue(numberofRoomsString.charAt(0));

      int cntr = 0;
      for (int i = 1; i < numberofFloors + 2; i++) {

         //Iterate until number of rooms is reached
         for (int j = 1; j < numberofRooms + 1; j++) {

            if(cntr >= numberofRooms){
               break;
            }

            //Create room numbers based off floor
            int roomID;
            if(j < 10){
               roomID = Integer.valueOf(i + "0" + j);
            }else{
               roomID = Integer.valueOf(i + "" + j);
            }
            
            Rooms room;

            if(roomID >= Integer.valueOf(numberofFloors + 1 + "0" + j)){
               room = new RoomsSuite(roomID, null);
            }else{
               room = new Rooms(roomID, null);
            }

            //Last room in any hotel is penthouse
            if(cntr == (numberofRooms - 1)){
               room = new RoomsPentHouse(roomID, null);
            }

            //Assign passed room to array
            addRoom(room, cntr);
            
            //10 rooms per floor
            if (j >= 10) {
               j = 1;
               cntr++;
               break;
            }
            cntr++;
         }

      }

   }

   //Assign passed room to array
   public void addRoom(Rooms rooms, int arrayLocation){
      //this.rooms.add(rooms);
      this.roomsArray[arrayLocation] = rooms;
   }

   public Rooms[] getArray(){
      //this.rooms.add(rooms);
      return roomsArray;
   }

   //Return employeeArray
   public ArrayList<Employees> getEmployeesArray() {
      return employeesArray;
   }

   //Return historic guest stays
   public ArrayList<GuestArchive> getGuestHistoricStaysArray() {
      return guestHistoricStaysArray;
   }

   //Return roomsArray length, which is the amount of rooms
   public int getNumRooms(){
      return roomsArray.length;
   }

   //Output room info
   public void getRoomInfo(int roomID){
      
      //Assume passed roomID is not within Hotel list/array
      Boolean bContains = false;

      for (Rooms room : roomsArray) {
         if(room.getRoomID() == roomID){
            //Update boolean, output messages, and break loop
            bContains = true;
            System.out.println("Room number: " + roomID + ". Guest is " + room.getGuest().getGuestName() + " and ID is: " + room.getGuest().getuserID());
            break;
         }
      }

      //If bContains is still false, output message
      if(!bContains){
         System.out.println("The room " + roomID + " does not exist");
      }

   }

   //Get list of all occupied rooms
   public void getRoomInfo(){
      
      for (Rooms room : roomsArray) {
         if(room.getGuest() != null){
            System.out.println("Room number: " + room.getRoomID() + ". Guest is " + room.getGuest().getGuestName() + " and ID is: " + room.getGuest().getuserID());
            System.out.println("\tRoom type: " + room.getRoomType() + ". Nightly Cost: $" + room.getRoomCost());
            room.getFeatures();
            System.out.println("\tCheck in date: " + room.getStartDate());
            System.out.println("\tCheck out date: " + room.getEndDate());

         }
      }

   }

   //Get list of all employees
   public void getEmployeesInfo(){
      
      for (Employees employees : employeesArray) {
         
         //User BigDecimal to round employee salary
         BigDecimal number = new BigDecimal(employees.getHourlyWage());
         RoundingMode roundingMode = RoundingMode.HALF_UP;
         BigDecimal roundedNumber = number.setScale(2, roundingMode);

         System.out.println("Employee: " + employees.getName() + ". Job title: " + employees.getJobTitle() + " Wage: " + roundedNumber+ " and ID is: " + employees.getEmpID() + ". Status: " + employees.isActiveEmployee());
      }

   }

   //Get list of all occupied rooms
   public void getGuestHistoricalInfo(){
      
         for (GuestArchive guestArchive : guestHistoricStaysArray) {
            System.out.println("Guest: " + guestArchive.getGuestName() + ". Days stayed: " + guestArchive.getNumberofDaysStayed() + " Room type: " + guestArchive.getRoomType() + " and ID is: " + guestArchive.getuserID() + ".");
         }

   }

   //Get count of occupied rooms
   public int getAvailableRoomCount(){
      int cntr = 0;
      for (Rooms room : roomsArray) {
         if(room.getGuest() == null){
            cntr++;
         }
      }
      return cntr;
   }

   //Get list of all unclean rooms
   public void getUncleanRooms(){
      for (int i = 0; i < roomsArray.length; i++) {
         Rooms room = roomsArray[i]; 
         if (!room.isClean()) {
             System.out.println("Unclean room number: " + room.getRoomID());
         }
     }
   }

   //Get list of all occupied rooms
   public int getAvailableRoom(String roomType){
      
      Scanner scanner = new Scanner(System.in);
      boolean exit = false;

      for (int i = 0; i < roomsArray.length; i++) {
         Rooms room = roomsArray[i]; 
         if (room.getRoomType().equals(roomType) && room.getGuest() == null) {
             return i;
         }
     }
     // No available room found, ask if any other room type is desired
     do{
      try {

         //Get available rooms available
         if(this.getAvailableRoomCount() == 0){
            return -1;
         }

      System.out.print(roomType + "Room type unavailable. Would you like to search for any available room other than " + roomType + "?:\n\n1. Yes\n2. No\n");
      int roomTypeInt = scanner.nextInt();      

      //Search for any available room
      switch (roomTypeInt) {
         case 1: 
            for (int i = 0; i < roomsArray.length; i++) {
               Rooms room = roomsArray[i]; 
               if (room.getGuest() == null) {
                  return i;
               }
            }
            break;
         case 2: return -1;
         default:System.out.println("Invalid option"); break;
      }
   }
      catch (InputMismatchException e) {
         System.out.println("Please enter a valid numeric option.");
         scanner.next();
   }
   }while(exit==false); return -1;
   }



}
