import java.io.*;

class StudentRecords {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//reading the text file to input text in it 

    // Method to add records to the file
    public void addRecords() throws IOException {
        // Create or modify a file for database
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("studentRecords.txt", true)));
        String name, studentClass;
        int rollNo, gradeNo;
        String choice;
        
        // Read data and write to file
        do {
            System.out.print("\nEnter name: ");
            name = br.readLine();
            System.out.print("Class: ");
            studentClass = br.readLine();
            System.out.print("Roll number: ");
            rollNo = Integer.parseInt(br.readLine());
            System.out.print("Grade number: ");
            gradeNo = Integer.parseInt(br.readLine());
            
            // Print to file
            pw.println(name);
            pw.println(studentClass);
            pw.println(rollNo);
            pw.println(gradeNo);
            
            System.out.print("\nRecords added successfully!\n\nDo you want to add more records? (y/n): ");
            choice = br.readLine();
        } while (choice.equalsIgnoreCase("y"));
        
        pw.close();
        showMenu();
    }

    // Method to read records from the file and display them
    public void readRecords() throws IOException {
        try {
            // Open the file
            BufferedReader file = new BufferedReader(new FileReader("studentRecords.txt"));
            String name;
            int i = 1;
            
            // Read records from the file
            while ((name = file.readLine()) != null) {
                System.out.println("S.No.: " + (i++));
                System.out.println("-------------");
                System.out.println("\nName: " + name);
                System.out.println("Student Class: " + file.readLine());
                System.out.println("Roll number: " + file.readLine());
                System.out.println("Grade Number: " + file.readLine());
                System.out.println();
            }
            
            file.close();
            showMenu();
        } catch (FileNotFoundException e) {
            System.out.println("\nERROR: File not found!");
            showMenu();
        }
    }

    // Method to clear all records from the file
    public void clear() throws IOException {
        // Create a blank file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("studentRecords.txt")));
        pw.close();
        System.out.println("\nAll records cleared successfully!");
        for (int i = 0; i < 999999999; i++) ; // Wait for some time
        showMenu();
    }

    // Method to display the menu and handle user choices
    public void showMenu() throws IOException {
        System.out.print("1: Add Records\n2: Display Records\n3: Clear All Records\n4: Exit\n\nYour Choice: ");
        int choice = Integer.parseInt(br.readLine());
        switch (choice) {
            case 1:
                addRecords();
                break;
            case 2:
                readRecords();
                break;
            case 3:
                clear();
                break;
            case 4:
                System.exit(1);
                break;
            default:
                System.out.println("\nInvalid Choice!");
                showMenu();
                break;
        }
    }

    
}

public class Assignment_5{

    public static void main(String args[]) throws IOException {
        StudentRecords studentRecords = new StudentRecords();
        studentRecords.showMenu();
    }
}
