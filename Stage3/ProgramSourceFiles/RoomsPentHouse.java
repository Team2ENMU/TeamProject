public class RoomsPentHouse extends RoomsSuite {

   private String roomType;
   private float roomCost = 210.00f;

   /**
    * @param roomID
    * @param name
    */
   public RoomsPentHouse(int roomID, String name) {
      super(roomID, name);
      this.roomType = "PentHouse";
   }
   //Return roomtype
   public String getRoomType() {
      return roomType;
   }

   //Show features
   public String getFeatures() {
      pentHouseFeatures();
      return "";
   }

   //Return roomCost
   public float getRoomCost() {
      return roomCost;
   }

   //Set roomCost
   public void setRoomCost(float roomCost) {
      this.roomCost = roomCost;
   }

   /**
    * (overriding)
   * @return void
   */
   public void pentHouseFeatures()
   {
      //Call suite features and display these as well
      super.getFeatures();
      System.out.println("\tNOTICE: this room requires cleaing daily.");
      System.out.println("\tFree WIFI also available. WiFi password for " + this.getRoomID()+ " is CS_234!");
   }


}
