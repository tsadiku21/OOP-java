package student_registration;

import java.util.*;

public class Student_Registration
{
    public static void main(String[] args) 
    {
         Student st=new Student();
         Scanner out=new Scanner(System.in);
         int f;
        boolean exit=true; 
          welcome();
            do{
          
                Menu();
            try{
        System.out.print("\t\tEnter your choice : ");
                f=out.nextInt();
                 if(f==1) 
                 {
                  st.Register();
                 }
                 else  if(f==2)
                 {
                     st.Display();
                }
                
                  else  if(f==3)
                 { 
                                       
                 
                     st.Remove();
                        }
                  else  if(f==4)
                 {
                     Scanner b=new Scanner(System.in);
                     System.out.println("Please Enter the ID of Student to be Searched : ");
                     String id=b.nextLine();
                     st.Search(id);
                 }                
                 else
                   break;
             }
        catch(Exception e){
            System.out.println("Exception : "+e);
            break;
                      }
        }while(exit);
    }
 
    public static void welcome()
    {
        System.out.println("\t\t____________________________________________________");
        System.out.println("\t\t|WELLCOME   TO   OUR  OOP    PROJECT         |");
        System.out.println("\t\t----------------------------------------------------|");
        System.out.println("\t\t|PROJECT TITLE   : STUDENT MANAGEMENT SYSTEM      |");
        System.out.println("\t\t----------------------------------------------------|");
        System.out.println("\t\t|CLASS LEVEL : SECOND  YEAR  SECOND SEMISTER         |");
        System.out.println("\t\t| DEPARTMENT : COMPUTER SCIENCE STUDENT     |");
        System.out.println("\t\t|  GROUP: 6                                        |");
        System.out.println("\t\t|    Group Members Name           ID                |");
        System.out.println("\t\t|   1.TSADIKU KIBRU            NSR/1460/12         |");
        System.out.println("\t\t|   2.AMIR JEMAL               NSR/1787/12          |");
        System.out.println("\t\t|   3.MEZIGEBU MULAT           NSR/1024/12          |");
        System.out.println("\t\t|___________________________________________________|");
    }
    public static void Menu(){
        System.out.println("\t\t\t|_______________________________________________________________|" );
        System.out.println("\t\t\t|------The Main Menu of Student Mangement System-----------------|");
        System.out.println("\t\t\t|_______________________________________________________________|" );
        System.out.println("\t\t\t       Enter 1 to Register Student                            ***");
        System.out.println("\t\t\t       Enter 2 to Display Students                          ***");
        System.out.println("\t\t\t       Enter 3 to Delete  students                                    ***");
        System.out.println("\t\t\t       Enter 4 to Search  students                                    ***");
        System.out.println("\t\t\t      Any  other key to Exit                                  ***");
        System.out.println("\t\t\t*****************************************************************");
     }
}
