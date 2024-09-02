/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmentone;

import java.util.ArrayList;

/**
 *
 * @author themb
 */
public class Student {
    
    static ArrayList<Student> arrStudent = new ArrayList<Student>();
    
    String id;
    String name;
    String age;
    String email;
    String course;
    
    public Student(){
        id="";
        name="";
        age="";
        email="";
        course="";        
        
    }
    
    //setters
   public void set_id(String ID){
     this.id = ID;
   }
   public void set_name(String Name){
       this.name = Name;
   }
   public void set_age(String Age){
       this.age = Age;
   }
   public void set_email(String Email){
       this.email = Email;
   }
   public void set_course(String Course){
       this.course = Course;
   }
   //getters
    
   public String get_id(){
       return this.id;
   }
    public String get_name(){
       return this.name;
   }
     public String get_age(){
       return this.age;
   }
      public String get_email(){
       return this.email;
   }
       public String get_course(){
       return this.course;
   }
       
    //methods
   public boolean save_student(Student myStudent){
       
       boolean exist = false;
       if(arrStudent.size() == 0){
         arrStudent.add(myStudent);//adding student to list
         
       }else{
           //looping through array to check if student already exists
           for(int i = 0; i< arrStudent.size(); i++){
               if(arrStudent.get(i).get_id().equals(myStudent.get_id())){
                   exist = true;
                   break;
               }               
           }
           if(exist == false){
                   arrStudent.add(myStudent);// adding student to list
               }
       }
       return exist;
    }
   
   public Student search_student(String studentID){
       
       Student search = new Student();
       if(arrStudent.size() == 0){
           return search;
       }else{
           //Looping through array to check student with the student id
           for(int i = 0; i< arrStudent.size(); i++){
               if(arrStudent.get(i).get_id().equals(studentID)){
                   search = arrStudent.get(i);
                   break;
               }
           }
           return search;
       }
       
   }
   public boolean delete_student(String studentID){
      
       ArrayList<Student> newStudentList = new ArrayList<Student>();
       
       boolean delete = false;
       if(arrStudent.size() > 0){
           for(int i = 0; i< arrStudent.size(); i++){
               if(arrStudent.get(i).get_id().equals(studentID)){
                   delete = true;
               } else {
                   newStudentList.add(arrStudent.get(i));// adding student to list
               }              
           }
           
           arrStudent = newStudentList;
       }
       return delete;
   }
   
   public ArrayList<Student> print_student(Student print){
        return arrStudent;
   }
}
