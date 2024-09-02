package assignmentone;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kgothatso Magwaza ST10456830
 */
public class AssignmentOne {

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
    
        System.out.println("Student Management Application");
        System.out.println("**********************************");
        System.out.println("Enter (1) to launch menu or enter any other to exit");
        
            
            String choices = input.next();
            if(choices.equals("1")){
                boolean isMenu = false;
                while(!isMenu){
                isMenu = true;
                    System.out.println("Please Select one of the following menu items:\n"
                    + "choice 1) Capture a new student. \n"
                    + "choice 2) Search for a Student. \n"
                    + "choice 3) Delete a Student. \n"
                    + "choice 4) Print Student report. \n"
                    + "choice 5) Exit Application.");


                    String options = input.next();
                    /*Capture a new student.*/
                    if(options.equals("1")){

                        Student myStudent = new Student();

                        System.out.println("Enter the student id");
                        String id = input.next();
                        myStudent.set_id(id);

                        System.out.println("Enter the student name");
                        String name = input.next();
                        myStudent.set_name(name);

                        boolean isValidNum = false;
                        while(!isValidNum){
                            System.out.println("Enter the student age");
                            String age = input.next();                
                            boolean isNum = isNumeric(age);
                            if(!isNum || Integer.parseInt(age) >= 16 ){
                                isValidNum = true;
                               myStudent.set_age(age);
                            }else{
                               System.out.println("You have entered an incorrect student age\n" + "Please re-enter the student age >>");  
                            }
                        }
                        System.out.println("Enter the student email");
                        String email = input.next();
                        myStudent.set_email(email);

                        System.out.println("Enter the student course");
                        String course = input.next();
                        myStudent.set_course(course);
                        
                        Student myZ = new Student();
                        myStudent.save_student(myStudent);
                        boolean exists = myZ.save_student(myStudent);
                        if(exists == true){
                            System.out.println("Student information saved successfully");
                        }else{
                            System.out.println("Student already exists");
                        }
                        
                        System.out.println("*********************************************************");
                        System.out.println("Capture A New Student");
                        System.out.println("************************");
                        System.out.println("Enter  the student id: " + myStudent.get_id());
                        System.out.println("Enter  the student name: " + myStudent.get_name());
                        System.out.println("Enter  the student age: " + myStudent.get_age());
                        System.out.println("Enter  the student email: " + myStudent.get_email());
                        System.out.println("Enter  the student course: " + myStudent.get_course());
                        System.out.println("*********************************************************");
                        
                        System.out.println("Enter (1) to launch menu or enter any other to exit");
                        int launch = input.nextInt();
                        if(launch == 1){
                            isMenu =false;
                        }else{
                            System.exit(0);
                        }
                        
                        

                    }else if(options.equals("2"))/*Search for a Student.*/{
                        
                        Student myk = new Student();
                        System.out.print("Enter the student id to search: ");
                        String id = input.next();
                        Student search = myk.search_student(id);
                        if( myk.search_student(id) != null){
                            System.out.println("*************************************");
                            System.out.println("Student ID: " + search.id);
                            System.out.println("Student ID: " + search.name);
                            System.out.println("Student ID: " + search.age);
                            System.out.println("Student ID: " + search.email);
                            System.out.println("Student ID: " + search.course);
                            System.out.println("*************************************");                            
                        }else{
                            System.out.println("*************************************");
                            System.out.println("Student with student " + id + " was not found");
                            System.out.println("*************************************");
                        }
                        System.out.println("Enter (1) to launch menu or enter any other to exit");
                        int launch = input.nextInt();
                        if(launch == 1){
                            isMenu =false;
                        }else{
                            System.exit(0);
                        }

                    }else if(options.equals("3"))/*Delete a Student.*/{
                        
                        Student myD = new Student();
                        System.out.print("Enter the student id to search: ");
                        String id = input.next();
                        System.out.println("Are you sure you want to delete student from the system? Yes(y) to delete");
                        String press = input.next();
                        if(press.equals("y")){
                            boolean delete = myD.delete_student(id);
                            if(delete == true){
                                System.out.println("*************************************");
                                System.out.println("Student with student id " + id + " was deleted");
                                System.out.println("*************************************");
                            }
                        }else{
                           System.out.println("Student " + id + " was not deleted");
                        }
                        System.out.println("Enter (1) to launch menu or enter any other to exit");
                        int launch = input.nextInt();
                        if(launch == 1){
                            isMenu =false;
                        }else{
                            System.exit(0);
                        }
                        
                    }else if(options.equals("4"))/*Print Student report.*/{
                        
                        Student myStudent = new Student();
                        ArrayList<Student> results = myStudent.print_student(myStudent);

                        // Access the first student from the list
                        if (!results.isEmpty()) {
                            for(int i = 0; i< results.size(); i++){
                                Student student1 = results.get(i); // Accessing the first student in the list

                                
                                System.out.println("Student " + (i + 1));
                                System.out.println("*******************************************************");
                                System.out.println("Student ID: " + student1.id);
                                System.out.println("Student Name: " + student1.name);
                                System.out.println("Student Age: " + student1.age);
                                System.out.println("Student Email: " + student1.email);
                                System.out.println("Student Course: " + student1.course);
                                System.out.println("*******************************************************");
                            }
                        } else {
                            System.out.println("No students found in the list.");
                        }
                        System.out.println("Enter (1) to launch menu or enter any other to exit");
                        int launch = input.nextInt();
                        if(launch == 1){
                            isMenu =false;
                        }else{
                            System.exit(0);
                        }
                        
                    }else if(options.equals("5"))/*Exit Application.*/{
                        System.exit(0);
                    }
                }
            }else {
               System.exit(0); 
            }
        
            
        
            
    }
    //Checking if something is a number
    public static boolean isNumeric(String strNum){
        if(strNum == null) {
        return false;
    }
    try {
        int i = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
        
    }
    
    
}
