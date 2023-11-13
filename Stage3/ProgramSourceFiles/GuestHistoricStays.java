import java.util.ArrayList;

public class GuestHistoricStays {

   private ArrayList<Guest> guestHistoricStays;

   //Construct for ArrayList
   public GuestHistoricStays(){
      guestHistoricStays = new ArrayList<Guest>();
   }

   //Return Guest ArrayList
   public ArrayList<Guest> getGuestHistoricStays() {
      return guestHistoricStays;
   }

   //Set Guest ArrayList
   public void setGuestHistoricStays(ArrayList<Guest> guestHistoricStays) {
      this.guestHistoricStays = guestHistoricStays;
   }

}
