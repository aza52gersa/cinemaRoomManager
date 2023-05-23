import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] cinema = new String[rows][seats];
        for (int i = 0; i < rows; i++)
            for(int k = 0; k < seats; k++)
                cinema[i][k] = "S";

        boolean exitBoolean = false;
        while(!exitBoolean) {
            System.out.println();
            System.out.println(
                    """
                    1. Show the seats
                    2. Buy a ticket
                    0. Exit
                    """);
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    showSeats(cinema);
                    break;

                case 2:
                    System.out.println("Enter a row number: ");
                    int rowNumber = scanner.nextInt();
                    System.out.println("Enter a seat number in that row: ");
                    int seatNumber = scanner.nextInt();
                    buyTicket(cinema, rowNumber, seatNumber);
                    break;

                case 0:
                    exitBoolean = true;
                    break;

                default:
                    System.out.println("You entered the wrong number!");
                    exitBoolean = true;
            }
        }
    }

    public static void showSeats(String[][] cinema) {
        String[][] cinemaDuplicate = cinema;
        int horizontalNumbers = 1;
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        while (horizontalNumbers <= cinemaDuplicate[0].length) {
            System.out.print(horizontalNumbers + " ");
            horizontalNumbers++;
        }

        System.out.println();
        int verticalNumbers = 1;
        for (int i = 0; i < cinemaDuplicate.length; i++) {
            System.out.print(verticalNumbers + " ");
            for (int j = 0; j < cinemaDuplicate[i].length; j++) {
                System.out.print(cinemaDuplicate[i][j] + " ");
            }
            System.out.println();
            verticalNumbers++;
        }
    }
    public static void buyTicket(String[][] cinema, int rowNumber, int seatNumber) {
        cinema[rowNumber - 1][seatNumber - 1] = "B";
        ticketPrice(cinema, rowNumber);
    }
    public static void ticketPrice(String[][] cinema, int rowNumber) {
        int totalSeats = cinema.length * cinema[0].length;
        if (totalSeats < 60) {
            System.out.println("Ticket price: $10");
        } else {
            if (cinema.length / 2 >= rowNumber)
                System.out.println("Ticket price: $10");
            else
                System.out.println("Ticket price: $8"); //
        }
    }
}