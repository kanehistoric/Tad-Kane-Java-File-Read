
package writestudentaverages;

import java.io.*;   //Need to import for the FileWriter and PrintWriter classes
import java.util.*; //Need to import for the Scanner class

public class WriteStudentAverages {

    
    public static void main(String[] args) throws IOException   {
        System.out.println("Test1");
        System.out.println("Test2");
        System.out.println("Test3");
        System.out.println("This program uses a Scanner class object to scan in a text file of student names and grades,"
                + "\nsaving each line of the text file as an element in a String array.  The program parses each of these"
                + "\nelements to get the name and grades of each student, and calculate the average grade. It writes this info"
                + "\nto a separate output text file."
                + "\n\nThe First thing to do is:"
                + "\n1. Declare a Scanner object called sf"
                + "\n2. Declare a String array with plenty of space for saving string elements text[1000]"
                + "\n3. While the the Scanner object sf still has strings to get from the text file, "
                + "\n increment the array's index (maxIndx) and store each line of the text file as a new element of the string array.");
        
        //Specify the file path and text file we wish to write to:
        Scanner sf = new Scanner (new File("C:\\Users\\Admin\\Desktop\\STUFF\\AP Java\\LESSON 25\\WriteStudentAverages\\StudentScores.txt"));
        int maxIndx = -1; //-1 so when we increment below, the first index is 0
        String text[] = new String[1000]; //to be safe, declare more than we need
        
        while(sf.hasNext()) //while the Scanner object "sf" has any data in it from the txt file its scanning. As long as there's more text, keep going.
        {
            maxIndx++;      //start incrementing the array indices
            text[maxIndx] = sf.nextLine();  //each element of the array "text" is a new line of text from the scanned in text file
        }
        
        System.out.println("\nThe program then uses a for loop to print out each String element of the array (text[i].");
        for (int i=0; i<= maxIndx; i++) 
        {
            System.out.println("String element text[" + i + "] : " + text[i]);
        }
        System.out.println("\n");
        //maxIndx is now the highest index of text[], -1 if no text lines
        sf.close(); //We opened a file above so close it when finished.
        
        //we filled up the String array text[] with the lines of the text file.
        //let's see if it worked by printing out the array
        
        //String answer = "";     //This is a technique to start with an empty string and build an answer string.
                                  //But I'm not going to use it in this program.
        double average;
        System.out.println("The program then uses a for loop and nested while loop to calculate the average grade for each student."
        + "\n1. Use a for loop to create a new scanner object and fill it with each String element of the array (text[i])"
        + "\n2. Once we get the String element of the array from the for loop, we can parse that particular string's contents with a while loop."
        + "\n3. We capture the first element of the string element which is the name of the student (String name = sc.next())"
        + "\n4. We then use a while loop to parse through the remainder of the string, caturing each grade to calculate the average.\n");
        
        //***DECLARE YOUR FileWriter and PrintWriter objects outside the for and while loops, so you can close them oustide the loops as well.//
        //***This is key, because if you declare and open/close them inside the loop, just after the while statement, it will only print the
        //the last line scanned in.  Also, you can APPEND by adding the word "true" as a second paramete to the FileWriter("C:\\....", true) method
        //But then, it will keep adding all your strings over and over and over again.
        FileWriter fw = new FileWriter("C:\\Users\\Admin\\Desktop\\STUFF\\AP Java\\LESSON 25\\WriteStudentAverages\\output.txt");
        PrintWriter output = new PrintWriter(fw);
        for(int i = 0; i <= maxIndx; i++)    //DON'T do i < text.length, becuase 
        {                                    //the array was defined with 1000 elements, and we only used 4.
            Scanner sc = new Scanner(text[i]);  //notice we create a new scanner each time through the loop
            double totalGrades = 0;    //important to reset averagetotalGrades to zero each time, because each line of students grades will have a diff average
            //answer = "";    //reset the answer string - same rationale as average
            int grades = 0;
            
            //Now, let's parse through each line of text, which is the students grades and calc the average.
            String name = sc.next();  //Take the first token of the text[i] String element and assign to the name of the student. 
            while(sc.hasNext())       //We can now parse each token of the grades
            {
                grades++;
                int grade = sc.nextInt();
                totalGrades += grade;
                 
            }
            System.out.println(name + ", average = " + Math.round(totalGrades/grades));
//            FileWriter fw = new FileWriter("C:\\Users\\rkane\\Desktop\\AP Java\\LESSON 25\\WriteStudentAverages\\output.txt", true);
//            PrintWriter output = new PrintWriter(fw);
            output.println(name + ", average = " + Math.round(totalGrades/grades));
            
        }
        output.close();  //You have to close your PrintWriter object.
        fw.close();     //You have to close your FileWriter object.
    }
    
}