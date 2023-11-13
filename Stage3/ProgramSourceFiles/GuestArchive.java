public class GuestArchive extends Guest {

   private long numberofDaysStayed;
   private String roomType;


   public GuestArchive(String name, int userID, long numberofDaysStayed, String roomType) {
      super(name, userID);
      this.numberofDaysStayed = numberofDaysStayed;
      this.roomType = roomType;
   }

   /**
    * @return return days stayed
    */
   public long getNumberofDaysStayed() {
      return numberofDaysStayed;
   }

   /**
    * @param numberofDaysStayed set days stayed
    */
   public void setNumberofDaysStayed(long numberofDaysStayed) {
      this.numberofDaysStayed = numberofDaysStayed;
   }

   /**
    * @return RoomType
    */
   public String getRoomType() {
      return roomType;
   }

   /**
    * @param roomType setRoomType
    */
   public void setRoomType(String roomType) {
      this.roomType = roomType;
   }


   


}
