/*
 * 1. Caleb Palmares
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    public static void menu(Hotel hotel) {
        // Declare user input string and input
        String sUserSelection;
        Scanner scannerInput;

        //Ask user to make selection
        //Keep trying until proper input type is provided
        do {
            try {
                System.out.print("~~~Menu~~~\n" +
                        "1. List all occupied rooms\n" +
                        "2. Register/remove guest\n" +
                        "3. Register/retire guest employee\n" +
                        "4. List all employees\n" +
                        "5. List all previous guest stays\n" +   
                        "6. List all unclean rooms\n" +   
                        "7. Flip room 'clean' status\n" +                  
                        "8. Quit\n");

                scannerInput = new Scanner(System.in);
                sUserSelection = scannerInput.nextLine().trim();

                System.out.println("Option " + sUserSelection);

                switch (sUserSelection) {
                    case "1":
                        //List all occupied rooms
                        Option1.option1(hotel);
                        break;

                    case "2":
                        //Register/remove guest
                        hotel.roomsArray = Option2.option2(hotel);
                        break;

                    case "3":
                        //Register/edit new employee
                        hotel.employeesArray = Option3.option3(hotel);
                        break;

                    case "4":
                        //Output all employees
                        Option4.option4(hotel);
                        break;

                    case "5":
                        //Output all previous guest stays
                        Option5.option5(hotel);
                        break;

                    case "6":
                        //Output all unclean rooms
                        Option6.option6(hotel);
                        break;

                    case "7":
                        //Flip clean status
                        hotel.roomsArray = Option7.option7(hotel);
                        break;

                    case "8":
                        // If "8", then return and exit program
                        System.out.println("Bye\n~~~~~~~~~~~~~~~~~~");
                        scannerInput.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please enter a valid option.\n~~~~~~~~~~~~~~~~~~");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid numeric option.\n~~~~~~~~~~~~~~~~~~");
                scannerInput = new Scanner(System.in);
            }
        } while (true);
    }
}
