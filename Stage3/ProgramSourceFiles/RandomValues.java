/*
 * 1. Caleb Palmares
 */

import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RandomValues {

   //Generate random number of guests
   public static Rooms[] assignGuestsToRooms(int numberofRooms, Rooms[] aRooms){

      Random random = new Random();
      int randomClient = random.nextInt(numberofRooms - 1) + 1;

      //Output amount of random clients and header
      System.out.println(randomClient + " Guests created. " + "Room count: " + numberofRooms);

      //For every client, create a guest object and assign to arbitrary room
      Guest guest;
      for (int i = 1; i < randomClient + 1; i++) {

         guest = new Guest(numberofRooms);
         int randomRoomArray = random.nextInt(numberofRooms) + 1;

         //Decrement to prevent out of bounds exception
         randomRoomArray = randomRoomArray -1;

         //Get today's date
         LocalDate today = LocalDate.now();

         //Get the date, one week from today
         LocalDate nextWeek = today.plusWeeks(1);

         //Generate random dates within the range from avove
         int randomDate = generateRandomDateAsInt(today, nextWeek);

         //If index within room array is not empty, search for an empty index/room
         if(aRooms[randomRoomArray].getGuest() != null){

         //Start a beginning of array and search for empty 'room'
         for (int j = 0; j < numberofRooms; j++) {
            if (aRooms[j].getGuest() == null) {
               //Found an empty room, so now assign start date of today, random end date, and guest objectg
               randomDate = generateRandomDateAsInt(today, nextWeek);
               aRooms[j].setStartDate(Integer.parseInt(today.format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
               aRooms[j].setEndDate(randomDate);
               aRooms[j].setGuest(guest);
               break;
            } else {
               //If j iterator exceeds number of rooms, room array is at capacity
               if(j > numberofRooms){
                  System.out.println("Unable to assign any more rooms");
                  return aRooms;
               }
            }
         }

         }else{
            //Found an empty room, so now assign start date of today, random end date, and guest objectg
            randomDate = generateRandomDateAsInt(today, nextWeek);
            aRooms[randomRoomArray].setStartDate(Integer.parseInt(today.format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
            aRooms[randomRoomArray].setEndDate(randomDate);
            aRooms[randomRoomArray].setGuest(guest);

         }

         
      }

      return aRooms;

   }

   //method to generate random number as an int
   public static int generateRandomNumber(int min, int max){
      Random random = new Random();
      int randomNumber = random.nextInt(max - min + 1) + min;
      return randomNumber;
   }

   //method to generate random name. Use room count as random number
   /**
    * @param roomCount
    * @return
    */
   public String generateRandomGuestName(int roomCount){

      //Hardcode 100, return a name based on room count
      String[] randomNames = generateRandomNames(100);
      return randomNames[roomCount];

   }
   
   //helper method for generating names
   /**
    * @param count
    * @return
    */
   private static String[] generateRandomNames(int count) {
      String[] names = new String[count];
      for (int i = 0; i < count; i++) {
          names[i] = generateRandomName();
      }
      return names;
  }

   /**
    * @return random first/last name
    */
   private static String generateRandomName() {
      String[] firstNames = {"Richard","Gerald","Jimmy","Ronald","Abraham","Bill","George","Barack","Donald","Joe","Thomas"};
      String[] lastNames = {"Johnson","Nixon","Ford","Carter","Reagan","Clinton","Bush","Obama","Trump","Biden","Jefferson"};

      Random rand = new Random();
      String firstName = firstNames[rand.nextInt(firstNames.length)];
      String lastName = lastNames[rand.nextInt(lastNames.length)];

      return firstName + " " + lastName;
   }   

   //Help method to assign random date
   /**
    * @param startDate
    * @param endDate
    * @return
    */
   private static int generateRandomDateAsInt(LocalDate startDate, LocalDate endDate) {
      Random random = new Random();
      int randomDay = random.nextInt(endDate.getDayOfYear() - startDate.getDayOfYear() + 1) + startDate.getDayOfYear();
      LocalDate randomDate = LocalDate.ofYearDay(startDate.getYear(), randomDay);
      return Integer.parseInt(randomDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
   }







}
