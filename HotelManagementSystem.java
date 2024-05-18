package day6;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class HotelManagementSystem {
    private static Database db = Database.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeTestData();

        while (true) {
            System.out.println("Hotel Management System");
            System.out.println("1. Login as Normal User");
            System.out.println("2. Login as Hotel Agent");
            System.out.println("3. Login as Administrator");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    normalUserMenu();
                    break;
                case 2:
                    hotelAgentMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void initializeTestData() {
        // Creating some test data
        NormalUser user = new NormalUser(1, "ram", "ram@example.com", "password123");
        db.addUser(user);

        HotelAgent agent = new HotelAgent(2, "jain", "jain@example.com", "password123");
        db.addUser(agent);

        Administrator admin = new Administrator(3, "Admin", "admin@example.com", "password123");
        db.addUser(admin);

        Hotel hotel = new Hotel(1, "Grand Hotel", "delhi", 100, Arrays.asList("WiFi", "Breakfast"));
        db.addHotel(hotel);
        
        Room room1 = new Room(1, 1, true, 200.00);
        Room room2 = new Room(2, 1, true, 250.00);
        db.addRoom(room1);
        db.addRoom(room2);

        admin.approveHotel(1);
    }

    private static void normalUserMenu() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); 
        Optional<User> userOpt = db.getUserById(userId);

        if (userOpt.isPresent() && userOpt.get() instanceof NormalUser) {
        	System.out.println("Enter the password : ");
        	String password = scanner.nextLine();
        	if(userOpt.get().getPassword().equals(password)) {
            NormalUser user = (NormalUser) userOpt.get();
            while (true) {
                System.out.println("Normal User Menu");
                System.out.println("1. Search Hotels");
                System.out.println("2. Book Room");
                System.out.println("3. Give Feedback");
                System.out.println("4. View Bookings");
                System.out.println("5. Update Details");
                System.out.println("6. Logout");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); 

                switch (option) {
                    case 1:
                        System.out.print("Enter search criteria (name/location): ");
                        String criteria = scanner.nextLine();
                        user.searchHotels(criteria).forEach(h -> System.out.println(h.getHotelId() + ": " + h.getName() + " - " + h.getLocation()));
                        break;
                    case 2:
                        System.out.print("Enter Hotel ID: ");
                        int hotelId = scanner.nextInt();
                        System.out.print("Enter Room ID: ");
                        int roomId = scanner.nextInt();
                        user.bookRoom(hotelId, roomId);
                        break;
                    case 3:
                        System.out.print("Enter Hotel ID: ");
                        hotelId = scanner.nextInt();
                        System.out.print("Enter Rating (1-5): ");
                        int rating = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Comment: ");
                        String comment = scanner.nextLine();
                        user.giveFeedBack(hotelId, rating, comment);
                        break;
                    case 4:
                        user.getBookings().forEach(b -> System.out.println("Booking ID: " + b.getBookingId() + ", Hotel ID: " + b.getHotelId() + ", Room ID: " + b.getRoomId() + ", Status: " + b.getStatus()));
                        break;
                    case 5:
                        System.out.print("Enter new name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String email = scanner.nextLine();
                        user.setName(name);
                        user.setEmail(email);
                        user.updateDetails();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        	}else
        	{
        		System.out.println("invalid password");
        	}
        } else {
            System.out.println("User not found or invalid user type.");
        }
  
    }

    private static void hotelAgentMenu() {
        System.out.print("Enter Agent ID: ");
        int agentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Optional<User> userOpt = db.getUserById(agentId);

        if (userOpt.isPresent() && userOpt.get() instanceof HotelAgent) {
        	System.out.println("Enter the password : ");
        	String password = scanner.nextLine();
        	if(userOpt.get().getPassword().equals(password)) {
            HotelAgent agent = (HotelAgent) userOpt.get();
            while (true) {
                System.out.println("Hotel Agent Menu");
                System.out.println("1. Add Hotel");
                System.out.println("2. Update Hotel");
                System.out.println("3. Logout");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (option) {
                    case 1:
                        System.out.print("Enter Hotel Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Hotel Location: ");
                        String location = scanner.nextLine();
                        System.out.print("Enter Number of Rooms: ");
                        int numberOfRooms = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Facilities (comma separated): ");
                        String facilities = scanner.nextLine();
                        Hotel newHotel = new Hotel(db.getHotels().size() + 1, name, location, numberOfRooms, Arrays.asList(facilities.split(",")));
                        agent.addHotel(newHotel);
                        break;
                    case 2:
                        System.out.print("Enter Hotel ID: ");
                        int hotelId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Optional<Hotel> hotelOpt = db.getHotelById(hotelId);
                        if (hotelOpt.isPresent()) {
                            Hotel hotel = hotelOpt.get();
                            System.out.print("Enter new Hotel Name: ");
                            name = scanner.nextLine();
                            System.out.print("Enter new Hotel Location: ");
                            location = scanner.nextLine();
                            System.out.print("Enter new Number of Rooms: ");
                            numberOfRooms = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter new Facilities (comma separated): ");
                            facilities = scanner.nextLine();
                            hotel.updateDetails(name, location, numberOfRooms, Arrays.asList(facilities.split(",")));
                            agent.updateHotel(hotel);
                        } else {
                            System.out.println("Hotel not found.");
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        	}else
        	{
        		System.out.println("invalid password...");
            	
        	}
        } else {
            System.out.println("Agent not found or invalid user type.");
        }
    }

    private static void adminMenu() {
        System.out.print("Enter Admin ID: ");
        int adminId = scanner.nextInt();
        scanner.nextLine(); 
        Optional<User> userOpt = db.getUserById(adminId);

        if (userOpt.isPresent() && userOpt.get() instanceof Administrator) {
        	System.out.println("Enter the password : ");
        	String password = scanner.nextLine();
        	if(userOpt.get().getPassword().equals(password)) {
            Administrator admin = (Administrator) userOpt.get();
            while (true) {
                System.out.println("Administrator Menu");
                System.out.println("1. Approve Hotel");
                System.out.println("2. Delete User");
                System.out.println("3. Delete Hotel");
                System.out.println("4. Logout");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); 

                switch (option) {
                    case 1:
                        System.out.print("Enter Hotel ID: ");
                        int hotelId = scanner.nextInt();
                        admin.approveHotel(hotelId);
                        break;
                    case 2:
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        admin.deleteUser(userId);
                        break;
                    case 3:
                        System.out.print("Enter Hotel ID: ");
                        hotelId = scanner.nextInt();
                        admin.deleteHotel(hotelId);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        	}else
        	{
        		System.out.println("invalid password..");
            	
        	}
        } else {
            System.out.println("Admin not found or invalid user type.");
        }
    }
}