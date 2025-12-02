import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConcertBooking bookingSystem = new ConcertBooking();

        // Sample seats for one section
        String[] seats = new String[10];
        for (int i = 0; i < 10; i++) seats[i] = "S" + (i + 1);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Book a seat");
            System.out.println("2. Undo last booking");
            System.out.println("3. Show booked tickets");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter section name (e.g., VIP, Middle, Upper): ");
                    String sectionName = scanner.next();

                    System.out.println("Available seats:");
                    for (String seat : seats) {
                        if (!bookingSystem.isBooked(new ConcertTicket(sectionName, seat))) {
                            System.out.print(seat + " ");
                        }
                    }

                    System.out.print("\nChoose seat: ");
                    String chosenSeat = scanner.next();
                    ConcertTicket newTicket = new ConcertTicket(sectionName, chosenSeat);

                    if (bookingSystem.bookTicket(newTicket)) {
                        System.out.println("Ticket booked: " + newTicket);
                    } else {
                        System.out.println("Seat already booked!");
                    }
                    break;

                case 2:
                    ConcertTicket undone = bookingSystem.undoLastBooking();
                    if (undone != null) {
                        System.out.println("Cancelled last booking: " + undone);
                    } else {
                        System.out.println("No booking to undo.");
                    }
                    break;

                case 3:
                    System.out.println("\nBooked tickets:");
                    for (ConcertTicket t : bookingSystem.getBookedTickets()) {
                        System.out.println(t);
                    }
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        System.out.println("\nFinal booked tickets:");
        for (ConcertTicket t : bookingSystem.getBookedTickets()) {
            System.out.println(t);
        }

        scanner.close();
    }
}

