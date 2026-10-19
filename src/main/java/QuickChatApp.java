
import java.util.Scanner;

public class QuickChatApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        User user = new User();

        // =========================
        // USER REGISTRATION
        // =========================
        System.out.println("========== REGISTER ==========");

        System.out.print("Enter username: ");
        String regUser = input.nextLine();

        System.out.print("Enter password: ");
        String regPass = input.nextLine();

        System.out.print("Enter SA phone number: ");
        String regPhone = input.nextLine();

        user.register(regUser, regPass, regPhone);

        // =========================
        // USER LOGIN
        // =========================
        System.out.println("\n========== LOGIN ==========");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean loggedIn = user.login(loginUser, loginPass);

        if (!loggedIn) {
            System.out.println("Cannot continue.");
            return;
        }

        // WELCOME MESSAGE
       
        System.out.println("\nWelcome to QuickChat.");

    
        System.out.print("How many messages would you like to enter? ");
        int totalMessages = input.nextInt();
        input.nextLine();

        int currentMessage = 1;

        // Program keeps running until user selects Quit
        while (true) {

            System.out.println("\n========= MENU =========");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose option: ");

            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1 -> {
                    if (currentMessage > totalMessages) {
                        System.out.println("You have reached the maximum number of messages.");
                        break;
                    }

                    System.out.print("Enter recipient number: ");
                    String recipient = input.nextLine();

                    System.out.print("Enter your message: ");
                    String text = input.nextLine();

                    Message message = new Message(currentMessage, recipient, text);

                    System.out.println("\n" + message.checkRecipientCell());
                    System.out.println(message.checkMessageLength());

                    if (!message.checkMessageLength().equals("Message ready to send.")) {
                        break;
                    }

                    System.out.println("\nChoose an option:");
                    System.out.println("Send");
                    System.out.println("Store");
                    System.out.println("Discard");
                    System.out.print("Selection: ");

                    String choice = input.nextLine();

                    String result = message.sentMessage(choice);

                    System.out.println(result);

                    // Display full details if sent
                    if (choice.equalsIgnoreCase("send")) {

                        System.out.println("\nMESSAGE DETAILS");
                        System.out.println("Message ID: " + message.getMessageID());
                        System.out.println("Message Hash: " + message.getMessageHash());
                        System.out.println("Recipient: " + message.getRecipient());
                        System.out.println("Message: " + message.getMessage());
                    }

                    currentMessage++;
                }

                case 2 -> System.out.println("Coming Soon.");

                case 3 -> {
                    System.out.println("\nApplication closed.");
                    System.out.println("Total messages sent: " + Message.returnTotalMessages());
                    System.out.println(Message.printMessages());
                    return;
                }

                default -> System.out.println("Invalid option.");
           
                
            }
        }
    }
}
    

