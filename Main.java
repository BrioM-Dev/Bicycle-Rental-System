import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bicycle[][] bicycles = new Bicycle[4][4];
        boolean running = true;
        boolean nameExists;
        boolean isId = true;
        int row = 0;
        int col = 0;
        int id;
        String name;
        int choice;
        Users user = new Users("Liam Neeson", 12);
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println("Menu");
            System.out.println("Select the appropriate option below\n1. Add Bicycle\n2. View All Bicycles\n3. Borrow Bicycle\n" +
                    "4. Return Bicycle\n5. View Borrowed Bicycles\n6. Search Bicycle\n7. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Enter bicycle name:");
                        name = scanner.nextLine();
                        nameExists = false;
                        for (int i = 0; i < bicycles.length; i++) {
                            for (int j = 0; j < bicycles.length; j++) {
                                if (bicycles[i][j] != null && Objects.equals(bicycles[i][j].getBicycleName(), name)){
                                    System.out.println("ID already exists");
                                    nameExists = true;
                                    break;
                                }
                            }
                            if (nameExists) break;
                        }
                    }while (nameExists);

                    System.out.println("Enter bicycle make:");
                    String make = scanner.nextLine();

                    System.out.println("Enter bicycle type:");
                    String type = scanner.nextLine();

                    Bicycle bike = new Bicycle(name, make, type);
                    bicycles[row][col] = bike;

                    if (col < bicycles[row].length - 1){
                        col++;
                    }else{
                        col = 0;
                        if (row < bicycles.length - 1){
                            row++;
                        }else{
                            System.out.println("Can't add any more bicycles.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("--[List of All Bicycles]--");
                    for (int i = 0; i < bicycles.length; i++) {
                        for (int j = 0; j < bicycles[i].length; j++) {
                            if (bicycles[i][j] != null) {
                                Bicycle bikeShow = bicycles[i][j];
                                System.out.println("[" + i + "][" + j + "] " +
                                        "Name: " + bikeShow.getBicycleName() + ", " +
                                        "Make: " + bikeShow.getBicycleMake() + ", " +
                                        "Type: " + bikeShow.getBicycleType());
                            } else {
                                System.out.println("[" + i + "][" + j + "] Empty Slot");
                            }
                        }
                    }
                    System.out.println();
                    break;

                case 3:
                        System.out.println("Enter bicycle name:");
                        name = scanner.nextLine();
                        nameExists = false;
                        for (int i = 0; i < bicycles.length; i++) {
                            for (int j = 0; j < bicycles.length; j++) {
                                if (bicycles[i][j] != null && Objects.equals(bicycles[i][j].getBicycleName(), name)){
                                    System.out.println("Bicycle exists.");
                                    nameExists = true;
                                    if (bicycles[i][j].isAvaliable())
                                    {
                                        System.out.println("Bicycle " + name + " is available.");
                                        if (user.getNumberOfBorrowedBicycles() < 2) {
                                            user.addToList(name, bicycles[i][j].getBicycleMake(), bicycles[i][j].getBicycleType());
                                            bicycles[i][j].setAvailability(false);
                                            System.out.println("You have successfully borrowed a bike.");
                                        }
                                        else
                                            System.out.println("You have reached your limit of bicycles you are allowed to borrow.");
                                    }
                                    else
                                        System.out.println(name + " is unfortunately unavailable.");
                                    nameExists = true;
                                    break;
                                }
                            }
                            if (nameExists) break;
                        }
                        if (!nameExists) {
                            System.out.println("The bicycle you provided does not exist.");
                            break;
                        }

                    break;
                case 4:
                    System.out.println("Enter bicycle name:");
                    name = scanner.nextLine();
                    if (user.returnBicycle(name)){
                        for (int i = 0; i < bicycles.length; i++) {
                            for (int j = 0; j < bicycles.length; j++) {
                                if (bicycles[i][j] != null && Objects.equals(bicycles[i][j].getBicycleName(), name)) {
                                    System.out.println("Bicycle " + name + " returned.");
                                    bicycles[i][j].setAvailability(true);
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("--[Borrowed Bicycles]--");
                    ArrayList<Bicycle> borrowedBikes = user.getListOfBorrowedBicycles();

                    if (borrowedBikes.isEmpty()) {
                        System.out.println("No bicycles borrowed yet.");
                    } else {
                        for (int i = 0; i < borrowedBikes.size(); i++) {
                            Bicycle borrowedBike = borrowedBikes.get(i);
                            System.out.println((i + 1) + ". " +
                                    "Name: " + borrowedBike.getBicycleName() + ", " +
                                    "Make: " + borrowedBike.getBicycleMake() + ", " +
                                    "Type: " + borrowedBike.getBicycleType());
                        }
                    }
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Enter bicycle name to search:");
                    name = scanner.nextLine();
                    nameExists = false;
                    for (int i = 0; i < bicycles.length; i++) {
                        for (int j = 0; j < bicycles.length; j++) {
                            if (bicycles[i][j] != null && Objects.equals(bicycles[i][j].getBicycleName(), name)) {
                                System.out.println("Bicycle exists at position [" + i + "][" + j + "]");
                                nameExists = true;
                                break;
                            }
                        }
                        if (nameExists) break;
                    }
                    if (!nameExists)
                    {
                        System.out.println("The bicycle name you enter does not exist. Please try another name.");
                    }
                    break;
                case 7:
                    System.out.println("Thank you for using our services!");
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect option selected. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}