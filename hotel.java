import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

class Hotel {
    private int room_no;
    private String name;
    private String address;
    private String phone;
    private long days;
    private long cost;
    private String rtype;

    private void breakfast(int num) {
        // Implementation for breakfast method
    }

    private void lunch(int num) {
        // Implementation for lunch method
    }

    private void dinner(int num) {
        // Implementation for dinner method
    }

    public void mainMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("THE HOTEL");
            System.out.println();
            System.out.println("MAIN MENU");
            System.out.println();
            System.out.println("1. Book A Room:");
            System.out.println("2. Customer Information:");
            System.out.println("3. Rooms Allotted:");
            System.out.println("4. Search for customer");
            System.out.println("5. Edit Customer Details:");
            System.out.println("6. Order Food from Restaurant:");
            System.out.println("7. Total bill/payment of the customer ");
            System.out.println("8. Exit");
            System.out.println("Enter Your Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    rooms();
                    break;
                case 4:
                    customerDisplay();
                    break;
                case 5:
                    edit();
                    break;
                case 6:
                    restaurant();
                    break;
                case 7:
                    payment();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Wrong choice");
                    System.out.println("Press any key to continue.");
                    scanner.nextLine();
                    scanner.nextLine();
            }
        }
    }

    private void add() {
        int r, flag;
        try {
            PrintWriter fout = new PrintWriter(new FileWriter("record.data", true));
            Scanner scanner = new Scanner(System.in);
            System.out.println(" +-----------------------+");
            System.out.println(" | Rooms  |   Room Type  |");
            System.out.println(" +-----------------------+");
            System.out.println(" |   1-50 |    Deluxe    |");
            System.out.println(" |  51-80 |   Executive  |");
            System.out.println(" | 81-100 | Presidential |");
            System.out.println(" +-----------------------+");
            System.out.println(" ENTER CUSTOMER DETAILS");
            System.out.println("----------------------");
            System.out.println("Room Number: ");
            r = scanner.nextInt();
            flag = check(r);
            if (flag == 1) {
                System.out.println("Sorry, Room is already booked.");
            } else {
                if (flag == 2) {
                    System.out.println("Sorry, Room does not exist.");
                } else {
                    room_no = r;
                    System.out.println(" Name: ");
                    name = scanner.next();
                    System.out.println(" Address: ");
                    address = scanner.next();
                    System.out.println(" Phone Number: ");
                    phone = scanner.next();
                    System.out.println(" Number of Days: ");
                    days = scanner.nextLong();
                    if (room_no >= 1 && room_no <= 50) {
                        rtype = "Deluxe";
                        cost = days * 10000;
                    } else if (room_no >= 51 && room_no <= 80) {
                        rtype = "Executive";
                        cost = days * 12500;
                    } else if (room_no >= 81 && room_no <= 100) {
                        rtype = "Presidential";
                        cost = days * 15000;
                    }

                    fout.println(room_no + " " + name + " " + address + " " + phone + " " + days + " " + cost + " " + rtype);
                    System.out.println("Customer details added successfully!");
                }
            }
            fout.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void display() {
        try {
            BufferedReader fin = new BufferedReader(new FileReader("record.data"));
            String str;
            System.out.println("+--------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-10s | %-10s | %-15s |\n", "Room No.", "Name", "Address", "Phone", "Days", "Cost", "Room Type");
            System.out.println("+--------------------------------------------------------------------------------------------------+");
            while ((str = fin.readLine()) != null) {
                String[] split = str.split(" ");
                System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-10s | %-10s | %-15s |\n", split[0], split[1], split[2], split[3], split[4], split[5], split[6]);
            }
            System.out.println("+--------------------------------------------------------------------------------------------------+");
            fin.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void rooms() {
        try {
            BufferedReader fin = new BufferedReader(new FileReader("record.data"));
            String str;
            System.out.println("+---------------------------------+");
            System.out.println("|      Allotted Rooms List        |");
            System.out.println("+---------------------------------+");
            while ((str = fin.readLine()) != null) {
                String[] split = str.split(" ");
                System.out.println("| Room No.: " + split[0] + " | Room Type: " + split[6] + " |");
            }
            System.out.println("+---------------------------------+");
            fin.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void customerDisplay() {
        try {
            BufferedReader fin = new BufferedReader(new FileReader("record.data"));
            String str;
            int flag = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the customer: ");
            String customerName = scanner.next();
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-10s | %-10s | %-15s |\n", "Room No.", "Name", "Address", "Phone", "Days", "Cost", "Room Type");
            System.out.println("+---------------------------------------------------------------------------+");
            while ((str = fin.readLine()) != null) {
                String[] split = str.split(" ");
                if (split[1].equalsIgnoreCase(customerName)) {
                    System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-10s | %-10s | %-15s |\n", split[0], split[1], split[2], split[3], split[4], split[5], split[6]);
                    flag = 1;
                }
            }
            System.out.println("+---------------------------------------------------------------------------+");
            if (flag == 0) {
                System.out.println("No customer found with the given name.");
            }
            fin.close();
        } catch (IOException e) {
            System.out.println
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void edit() {
        try {
            BufferedReader fin = new BufferedReader(new FileReader("record.data"));
            PrintWriter fout = new PrintWriter(new FileWriter("temp.data", true));
            Scanner scanner = new Scanner(System.in);
            String str;
            int flag = 0;
            System.out.println("Enter the name of the customer to edit details: ");
            String customerName = scanner.next();
            while ((str = fin.readLine()) != null) {
                String[] split = str.split(" ");
                if (split[1].equalsIgnoreCase(customerName)) {
                    System.out.println("Enter new address: ");
                    String newAddress = scanner.next();
                    System.out.println("Enter new phone number: ");
                    String newPhone = scanner.next();
                    split[2] = newAddress;
                    split[3] = newPhone;
                    str = String.join(" ", split);
                    flag = 1;
                }
                fout.println(str);
            }
            if (flag == 0) {
                System.out.println("No customer found with the given name.");
            } else {
                System.out.println("Customer details updated successfully!");
            }
            fin.close();
            fout.close();

            // Rename temp file to replace the original file
            File oldFile = new File("record.data");
            File newFile = new File("temp.data");
            if (oldFile.delete() && newFile.renameTo(oldFile)) {
                System.out.println("File updated successfully!");
            } else {
                System.out.println("Error updating file.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void restaurant() {
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");
        System.out.println("Enter your choice: ");
        num = scanner.nextInt();
        switch (num) {
            case 1:
                breakfast(num);
                break;
            case 2:
                lunch(num);
                break;
            case 3:
                dinner(num);
                break;
            default:
                System.out.println("Wrong choice");
        }
    }

    private void payment() {
        try {
            BufferedReader fin = new BufferedReader(new FileReader("record.data"));
            Scanner scanner = new Scanner(System.in);
            String str;
            int flag = 0;
            System.out.println("Enter the name of the customer: ");
            String customerName = scanner.next();
            while ((str = fin.readLine()) != null) {
                String[] split = str.split(" ");
                if (split[1].equalsIgnoreCase(customerName)) {
                    System.out.println("Customer Name: " + split[1]);
                    System.out.println("Room Number: " + split[0]);
                    System.out.println("Total Cost: " + split[5]);
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("No customer found with the given name.");
            }
            fin.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.mainMenu();
    }
}


