public class Guest {
      //Declare variables
      private String guestName;
      
      //Use an incrementer for userIDs if guest is new
      private static int count = 1000;
      private int userID;
   
      //Guest constructor for random objects
      public Guest(int numberofRooms) {
         count++;
         RandomValues randomName = new RandomValues();
         this.guestName = randomName.generateRandomGuestName(numberofRooms);
         userID = count;
      }

      //Construct for staff entry without a known guest ID
      public Guest(String name) {
         count++;
         this.guestName = name;
         userID = count;
      }

      //Construct for staff entry with a known guest ID
      public Guest(String name, int userID) {
         this.guestName = name;
         this.userID = userID;
      }

      /**
       * @return guestName
       */
      public String getGuestName(){
         return guestName;
      }
 
      /**
       * @return userID
       */
      public int getuserID(){
         return userID;
      }
   
      /**
       * @param guestName setName
       */
      public void setName(String guestName){
         this.guestName = guestName;
      }
   

}
