/* 
    Create a library management system which is capable of issuing books to the students. 
    Book should have info like: 
    1. Book name 
    2. Book Author 
    3. Issued to 
    4. Issued on 
    User should be able to add books, return issued books, issue books 
    Assume that all the users are registered with their names in the central database 
*/

/*
 1->Register
 2->addBook
 3->issueBook
 4->return issue Book
 */

 import java.util.HashSet;
 import java.util.Scanner;
 
 class centralLibrary{
     //ArrayList<String> bookName = new ArrayList<>();
     //store book names in library
     HashSet<String> bookList = new HashSet<>();
     //store registered student details
     HashSet<String> registeredStudent = new HashSet<>();
     //store issued book with Details of student who take it
     HashSet<String> issueDetails = new HashSet<>();
 
     centralLibrary(){
         this.bookList.add("Noor-Eh_Khuda");
         this.bookList.add("Life Of Coder");
         this.bookList.add("Happy Journey");
         this.bookList.add("Mahabharat");
         this.bookList.add("Ram: A unbeatable warrior");
     }
     //Registeration of students
     public void register(String name,int roll){
         this.registeredStudent.add(roll+"-"+name);
         System.out.println(name +" registered Successfully");
     }
 
     //Adding book in Library
     public void addBook(String book_name){
             this.bookList.add(book_name);
             System.out.println(book_name + " added Successfully");
     }
 
     //Book issue to Students
     public void issueBook(String book_name,String st_name,int roll){
         if(this.bookList.contains(book_name)&& this.registeredStudent.contains(roll+"-"+st_name)){
             this.bookList.remove(book_name);
             this.issueDetails.add(book_name+":"+roll+"-"+st_name);
             System.out.println("\""+book_name+"\" issued to "+st_name);
         }
         else{
             System.out.println("{Book is not available} OR {please register first}");
         }
     }
 
     //Return issue books
     public void returnIssuedBook(String book_name,String st_name,int roll){
         if(this.issueDetails.contains(book_name+":"+roll+"-"+st_name)){
             this.bookList.add(book_name);
             this.issueDetails.remove(book_name+":"+roll+"-"+st_name);
             System.out.println("\""+book_name+"\" returned");
         }
         else{
             System.out.println("Enter correct details");
         }
 
     }
 
     public void removeFromLibrary(String book_name){
         if(this.bookList.contains(book_name)){
             this.bookList.remove(book_name);
             System.out.println(book_name+" removed");
         }
     }
 
     public void checkAvailableBooks(){
         System.out.println("Available books are: "+this.bookList);
     }
 
     public void checkIssuedBookDetail(){
         System.out.println("Issue book details:"+this.issueDetails);
     }
 }
 public class Solution {
 
     public static void main(String[] args) {
         System.out.println("**-- CENTRAL LIBRARY --**");
         Scanner sc = new Scanner(System.in);
         
         
         centralLibrary c = new centralLibrary();
         while(true){
             System.out.println("1->Register\r\n"+"2->addBook\r\n"+"3->issueBook\r\n"+"4->return issue Book\r\n"+"5->Show Available Book\r\n"+"6->Show Issued Book Details\r\n"+"7->Remove Book From Library");
             System.out.print("Enter number according to above details: ");
             int a = sc.nextInt();
         switch(a){
             case 1: System.out.print("Enter roll_no: ");
                     int roll = sc.nextInt();
                     sc.nextLine(); //Why this is added here(**doubt)??
                     System.out.print("Enter name: ");
                     String st_name = sc.nextLine();
                     c.register(st_name, roll);
                     System.out.println("-----------------------");
                     break;
             case 2: sc.nextLine();
                     System.out.print("Enter Book_Name: ");
                     String book_name = sc.nextLine();
                     c.addBook(book_name);
                     System.out.println("-----------------------");
                     break;
             case 3: System.out.print("Enter roll_no: ");
                     int roll1 = sc.nextInt();
                     sc.nextLine(); //Why this is added here(**doubt)??
                     System.out.print("\nEnter name: ");
                     String st_name1 = sc.nextLine();
                     System.out.print("\nBook Name: ");
                     String book_name1 = sc.nextLine();
                     c.issueBook(book_name1, st_name1, roll1);
                     System.out.println("-----------------------");
                     break;
             case 4: System.out.print("\nEnter roll_no: ");
                     int roll2 = sc.nextInt();
                     sc.nextLine(); //Why this is added here(**doubt)??
                     System.out.print("Enter name: ");
                     String st_name2 = sc.nextLine();
                     System.out.print("\nBook Name: ");
                     String book_name2 = sc.nextLine();
                     c.returnIssuedBook(book_name2, st_name2, roll2);
                     System.out.println("-----------------------");
                     break;
             case 5: c.checkAvailableBooks();
                     System.out.println("-----------------------");
                     break;
             case 6: c.checkIssuedBookDetail();
                     System.out.println("-----------------------");
                     break;
             case 7: sc.nextLine(); //Why this is added here(**doubt)??
                     System.out.print("Enter Book Name: ");
                     String book_name3=sc.nextLine();
                     c.removeFromLibrary(book_name3);
                     System.out.println("-----------------------");
                     break;
             }
         }
         
         
     }
 }