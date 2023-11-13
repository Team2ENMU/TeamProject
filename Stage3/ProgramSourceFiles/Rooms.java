
public class Rooms {
  
    //Declare variables
    private int roomID;
    private String name;
    private boolean clean = true;
    private String roomType;
    private float roomCost = 100.00f;
    private int startDate = -1;
    private int endDate = -1;  
    private Guest guest;

    //Assign passed variables to object
    public Rooms(int roomID, String name){
        this.roomID = roomID;
        this.name = name;
        this.roomType = "Standard";
    }

    //return roomtype as features as standard. No additional features for this
    public String getFeatures() {
        return roomType;
     }

     //return startdate
    public int getStartDate() {
        return startDate;
    }

    //Set startdate
    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    //return enddate
    public int getEndDate() {
        return endDate;
    }

    //Set enddate
    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    //return roomType
    public String getRoomType() {
        return roomType;
     }

     //Set roomtype
     public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
            
    //Return status
    public boolean isClean() {
        return clean;
    }

    //Output based on boolean. Flip status
    public void setClean(boolean clean) {
        if(clean) {
           System.out.println("Room is clean"); 
        }else{
            System.out.println("Room now queued for cleaning."); 
        }
        this.clean = clean;
    }
   
    //return roomID
      public int getRoomID(){
         return roomID;
      }
   
      //return name
      public String getName(){
         return name;
      }
   
      //Return guest
      public Guest getGuest(){
         return guest;
      }
      
      //Assign passed variable
      public void setroomID(short roomID){
         this.roomID = roomID;
      }
   
      public void setName(String name){
         this.name = name;
      }

      public void setGuest(Guest guest){
         this.guest = guest;
      }
   
    //setRoom ID with passed variable
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    //return roomcost
    public float getRoomCost() {
        return roomCost;
    }

    //Set room cost
    public void setRoomCost(float roomCost) {
        this.roomCost = roomCost;
    }

}
