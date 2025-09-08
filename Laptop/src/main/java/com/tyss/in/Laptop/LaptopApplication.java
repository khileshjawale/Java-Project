package com.tyss.in.Laptop;

import com.tyss.in.Laptop.dao.LaptopDAO;
import com.tyss.in.Laptop.entity.Laptop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;
@SpringBootApplication
public class LaptopApplication {

    @Bean
    public CommandLineRunner commandLineRunner(LaptopDAO theLaptopdao)
    {
        return runner->
        {
            Scanner sc = new Scanner(System.in);
            Laptop theLaptop = new Laptop(); // Assuming you already created DAO class
            int choice;

            do {
                System.out.println("\n=== Laptop Management Menu ===");
                System.out.println("1. Add Laptop(s)");
                System.out.println("2. Find Laptop by ID");
                System.out.println("3. Find Laptop by IMEI");
                System.out.println("4. Update Laptop (RAM/ROM)");
                System.out.println("5. Fetch All Data");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1: // Add Laptop(s)
                        System.out.println("Enter Number of Entries You want to make:");
                        int count = sc.nextInt();
                        for (int i = 0; i < count; i++) {
                            System.out.println("Enter the Brand of laptop:");
                            String brand = sc.next();

                            System.out.println("Enter the IMEI of laptop:");
                            long imei = sc.nextLong();

                            System.out.println("Enter the Processor of laptop:");
                            String processor = sc.next();

                            System.out.println("Enter the RAM of laptop:");
                            String ram = sc.next();

                            System.out.println("Enter the ROM of laptop:");
                            String rom = sc.next();

                            theLaptopdao.save(new Laptop(brand, imei, processor, ram, rom));
                        }
                        break;

                    case 2: // Find by ID
                        System.out.println("Enter ID of Your Laptop:");
                        Laptop byID = theLaptopdao.findById(sc.nextInt());
                        System.out.println(byID);
                        break;

                    case 3: // Find by IMEI
                        System.out.println("Enter IMEI of Your Laptop:");
                        Laptop byImei = theLaptopdao.findByImei(sc.nextLong());
                        System.out.println(byImei);
                        break;

                    case 4: // Update Laptop (RAM/ROM)
                        System.out.println("Enter ID of the Laptop you want to update:");
                        int id = sc.nextInt();

                        System.out.println("What do you want to update?");
                        System.out.println("1. RAM");
                        System.out.println("2. ROM");
                        int updateChoice = sc.nextInt();

                        if (updateChoice == 1 ||updateChoice == 2) {
                            System.out.println("Enter new RAM value:");
                            theLaptopdao.update(id);
                        } else {
                            System.out.println("Invalid update option.");
                        }
                        break;
                    case 5:
                        System.out.println("All Data Fetched");
                        List<Laptop> all= theLaptopdao.fetchAll();
                        for (Laptop laptop :all)
                            System.out.println(all);
                        break;
                    case 6: // Exit
                        System.out.println("Exiting... Thank you!");
                        break;

                    default:
                        System.out.println("Invalid Choice. Please try again.");
                }

            } while (choice != 6);


        };
    }


	public static void main(String[] args) {
		SpringApplication.run(LaptopApplication.class, args);
	}

}
