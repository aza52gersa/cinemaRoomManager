import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        String[][] cinema = new String[rows][numberOfSeats];

        int number = 1;
        System.out.println("Cinema:");
        System.out.print("  ");
        while (number <= numberOfSeats){
            System.out.print(number + " ");
            number++;
        }

        int number2 = 1;
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(number2 + " ");
            for (int j = 0; j < numberOfSeats; j++) {
                cinema[i][j] = "S";
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
            number2++;
        }

        System.out.println();
        System.out.println("Enter a row number:");
        int userRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int userSeat = scanner.nextInt();
        System.out.println();

        if (rows * numberOfSeats < 60)
            System.out.println("Ticket price: $10");
        else
        if (rows / 2 >= userRow)
            System.out.println("Ticket price: $10");
        else
            System.out.println("Ticket price: $8");

        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        int number3 = 1;
        while (number3 <= numberOfSeats){
            System.out.print(number3 + " ");
            number3++;
        }

        int number4 = 1;
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(number4 + " ");
            for (int j = 0; j < numberOfSeats; j++) {
                if (i == userRow - 1 && j == userSeat - 1) {
                    cinema[i][j] = "B";
                    System.out.print(cinema[i][j] + " ");
                } else {
                    cinema[i][j] = "S";
                    System.out.print(cinema[i][j] + " ");
                }
            }
            System.out.println();
            number4++;
        }
    }
}