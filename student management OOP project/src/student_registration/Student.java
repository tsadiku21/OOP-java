
package student_registration;

import java.io.*;
import java.util.*;
class Student extends Abstract_Class implements Interface{
    Scanner in=new Scanner(System.in);
         String id;
	 String Fname;
	 String Lname;
	 String sex;
         String department;
         double GPA;
         

            
         
        public void Register()
        {
            String f,newStudent;
            System.out.println("Enter id");
            id=in.nextLine();
               while(check(id))
               {
               System.out.println(" Sorry !!!! ID Duplicate try again\n Enter student id : ");
               id=in.nextLine();
               }  
            System.out.println("enter first name");
            Fname=in.nextLine();
            System.out.println("Enter last name");
            Lname=in.nextLine();
            System.out.println("enter sex");
            sex=in.nextLine();
             System.out.println("Enter department");
            department=in.nextLine();
            System.out.println("Enter grade");
            GPA=in.nextDouble();
   newStudent="\n"+id+"\t "+Fname+"\t "+Lname+"\t "+sex+"\t "+department+" \t\t"+GPA;            
                try
                {
                byte[] b=newStudent.getBytes();                  
              
 FileOutputStream s_info=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\pop\\new.txt",true);
                s_info.write(b);
                
         System.out.println("You are Successfully Registered"); 
         s_info.close();
                }
                catch(Exception e)
                {
                    System.out.println("Register is failed !!!" +e);
                }
        
            }
        
        public void Remove(){
	        String filein,StuID;
	Scanner scan=new Scanner(System.in);
	    boolean t=false;
	try{
	 File tempStu = new File("C:\\Users\\Administrator\\Desktop\\pop\\temp.txt");
	  File Filebefore=new File("C:\\Users\\Administrator\\Desktop\\pop\\new.txt");
         BufferedReader prev = new BufferedReader(new FileReader(Filebefore));
	   BufferedWriter next = new BufferedWriter(new FileWriter(tempStu));
	      System.out.println("Enter the Id of student to be to Removed");
	StuID = scan.nextLine();
	while((filein=prev.readLine()) != null)
	{
	    if(filein.startsWith(StuID))
	         {
	          t=true;
	           continue;
	             }
		 next.write(filein);
                 next.flush();
	          next.newLine();
	            }
	       prev.close();
		next.close();
	            Filebefore.delete();
	           tempStu.renameTo(Filebefore);
	          if(t==true)
			System.out.println("File deletion performed successfully");
	      else
	     System.out.println("File deletion  failed because no student with StuID  "+StuID+"  found");
	        }
	       catch(Exception e)
	        {
	         System.out.println("Student not Deleted ");
	      }
		                     }
	            


        public boolean Search(String stuid){
            String temp="";
            boolean o=false;
            try
            {

    FileInputStream fin=new FileInputStream("C:\\Users\\Administrator\\Desktop\\pop\\new.txt");
   Scanner df=new Scanner(fin);
   while(df.hasNextLine())
   {
       temp=df.nextLine();
       if(temp.startsWith(stuid))
       {
       System.out.println(temp);
       o=true;
       }
   }
   if(o==false)
    System.out.println("No student is found in the list with an ID_NO  "+stuid );
   df.close();
            }
            catch(IOException IO)
            {
            System.out.println("Student not found" +IO);
            }
            return o;
        }
       // @Override
        public void Display()
        {
          String temp="";
            System.out.println("stud_id\t   Fname\tLname\tsex\tdepartment\tgrade");       
          
            try
            {
            FileInputStream Fread=new FileInputStream("C:\\Users\\Administrator\\Desktop\\pop\\new.txt");
            Scanner sc=new Scanner(Fread);
            while(sc.hasNextLine())
            {
            temp=sc.nextLine();
            System.out.println(temp);
            }
            sc.close();
            }
            catch(IOException IO)
            {
            System.out.println("Display error..."+IO);
            }
            System.out.println("");
            }

                public boolean check(String ide)
        {
             String temp="";
            boolean o=false;
            
            try
            {

    FileInputStream fin=new FileInputStream("C:\\Users\\Administrator\\Desktop\\pop\\new.txt");
   Scanner df=new Scanner(fin);
   while(df.hasNextLine())
   {
       temp=df.nextLine();
       if(temp.startsWith(ide))
       {
       o=true;
       }
   }
 
   
   df.close();
            }
            catch(IOException IO)
            {
            System.out.println(" " +IO);
            }
            return o;
        } 
 
    public void welcome() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
}
                   