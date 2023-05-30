import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] cinema = new String[rows][seats];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(cinema[i], "S");
        }

        boolean exitBoolean = false;
        while(!exitBoolean) {
            System.out.println();
            System.out.println(
                    """
                    1. Show the seats
                    2. Buy a ticket
                    3. Statistics
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

                case 3:
                    statistics(cinema);
                    break;
                case 0:
                    exitBoolean = true;
                    break;

                default:
                    System.out.println("You entered the wrong number!");
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
        Scanner scanner = new Scanner(System.in);
        int rowDuplicate = rowNumber;
        int seatDuplicate = seatNumber;
        boolean exit = false;
        while (!exit) {
            if ((rowDuplicate <= cinema.length && rowDuplicate >= 0) && (seatDuplicate <= cinema[1].length && seatDuplicate >= 0)) {
                if (cinema[rowDuplicate - 1][seatDuplicate - 1].equals("B")) {
                    System.out.println("That ticket has already been purchased!");
                    System.out.println();
                    System.out.println("Enter a row number: ");
                    rowDuplicate = scanner.nextInt();
                    System.out.println("Enter a seat number in that row: ");
                    seatDuplicate = scanner.nextInt();
                } else {
                    cinema[rowDuplicate - 1][seatDuplicate - 1] = "B";
                    System.out.println();
                    ticketPrice(cinema, rowDuplicate);
                    exit = true;
                }
            } else {
                System.out.println("Wrong input!");
                System.out.println();
                System.out.println("Enter a row number: ");
                rowDuplicate = scanner.nextInt();
                System.out.println("Enter a seat number in that row: ");
                seatDuplicate = scanner.nextInt();
            }
        }
    }

    public static void statistics(String[][] cinema) {
        DecimalFormat df = new DecimalFormat("#.##");
        int purchasedTickets = 0;
        double percentage;
        int income = 0;
        int totalIncome = 0;

        int totalSeats = cinema.length * cinema[0].length;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {

                if (cinema[i][j].equals("B")) {
                    purchasedTickets += 1;

                    if (totalSeats <= 60) {
                        income += 10;
                    } else {
                        if (i < cinema.length / 2)
                            income += 10;
                        else
                            income += 8;
                    }
                }
            }
        }

        if (totalSeats < 60) {
            totalIncome = totalSeats * 10;
        } else {
            int frontRows = cinema.length / 2;
            int backRows = cinema.length - frontRows;
            totalIncome = (frontRows * cinema[0].length * 10) + (backRows * cinema[0].length * 8);
        }

        percentage = (100.00 / totalSeats) * purchasedTickets;
        String finalPercentage = String.format("%.2f", percentage);
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.println("Percentage: " + finalPercentage + "%");
        System.out.println("Current income: $" + income);
        System.out.println("Total income: $" + totalIncome);
    }

    public static void ticketPrice(String[][] cinema, int rowNumber) {
        int totalSeats = cinema.length * cinema[0].length;
        if (totalSeats < 60) {
            System.out.println("Ticket price: $10");
        } else {
            if (cinema.length / 2 >= rowNumber)
                System.out.println("Ticket price: $10");
            else
                System.out.println("Ticket price: $8");
        }
    }
}