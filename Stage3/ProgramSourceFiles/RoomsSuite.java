public class RoomsSuite extends Rooms {

   private String roomType;
   private float roomCost = 150.00f;

   /**
    * @param roomID
    * @param name
    */
   public RoomsSuite(int roomID, String name) {
      super(roomID, name);
      this.roomType = "Suite";
   }

   //return roomType
   public String getRoomType() {
      return roomType;
   }

   //Show features for suite
   public String getFeatures() {
      suiteFeatures();
      return "";
   }

   //Return roomCost
   public float getRoomCost() {
      return roomCost;
   }

  //SetRoomCost
  public void setRoomCost(float roomCost) {
      this.roomCost = roomCost;
  }

    /**
     * Showing payment details (overriding)
	 * @return void
     */
    public void suiteFeatures()
    {
        //super.paymentDetails();
        System.out.println("\tPlease enable pool access for client in " + super.getRoomID()+ ".");
    }
   
   
}
