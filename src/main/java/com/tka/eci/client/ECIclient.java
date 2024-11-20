package com.tka.eci.client;

import java.util.List;
import java.util.Scanner;

import com.tka.eci.controller.ECIcontroller;
import com.tka.eci.entity.Candidate;

public class ECIclient {
    public static void main(String[] args) {
        ECIcontroller con = new ECIcontroller();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. View all candidates");
            System.out.println("2. List by Party");
            System.out.println("3. List by Assembly");
            System.out.println("4. List by State and Party");
            System.out.println("5. List by Gender");
            System.out.println("6. List by Age (above a given age)");
            System.out.println("7. List by Status");
            System.out.println("8. Count of Accepted Candidates by Assembly");
            System.out.println("9. Insert new Candidate");
            System.out.println("10. Delete Candidate");
            System.out.println("11. Update Candidate");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    displayCandidates(con.allCandidate());
                    break;
                case 2:
                    System.out.print("Enter party name: ");
                    String party = sc.nextLine();
                    displayCandidates(con.listByParty(party));
                    break;
                case 3:
                    System.out.print("Enter assembly: ");
                    String assembly = sc.nextLine();
                    displayCandidates(con.listByAssembly(assembly));
                    break;
                case 4:
                    System.out.print("Enter state: ");
                    String state = sc.nextLine();
                    System.out.print("Enter party: ");
                    party = sc.nextLine();
                    displayCandidates(con.listByStateParty(state, party));
                    break;
                case 5:
                    System.out.print("Enter gender: ");
                    String gender = sc.nextLine();
                    displayCandidates(con.listByGender(gender));
                    break;
                case 6:
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    displayCandidates(con.listByAge(age));
                    break;
                case 7:
                    System.out.print("Enter status: ");
                    String status = sc.nextLine();
                    displayCandidates(con.listByStatus(status));
                    break;
                case 8:
                    System.out.print("Enter assembly: ");
                    assembly = sc.nextLine();
                    int count = con.countOfAcceptedCandidateByAssembly(assembly);
                    System.out.println("Accepted Candidates in " + assembly + ": " + count);
                    break;
                case 9:
                    displayCandidates(con.insertCandidate());
                    break;
                case 10:
                    System.out.print("Enter candidate ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    displayCandidates(con.deleteCandidate(deleteId));
                    break;
                case 11:
                    System.out.print("Enter candidate ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    displayCandidates(con.updateCandidate(updateId));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        sc.close();
    }

    private static void displayCandidates(List<Candidate> candidates) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-30s %-40s %-10s %-20s %-15s %-15s %-6s %-5s\n", 
                          "ID", "Name", "Party", "State", "Assembly", "AssemblyNo", "Status", "Gender", "Age");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Candidate can : candidates) {
            System.out.printf("%-5s %-30s %-40s %-10s %-20s %-15s %-15s %-6s %-5s\n",
                              can.getC_id(), can.getName(), can.getParty(), can.getState(), 
                              can.getAssembly(), can.getAssembly_no(), can.getStatus(), 
                              can.getGender(), can.getAge());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
