import java.util.*;
import java.io.*;
public class Exercise12_12 {
  /**Main method*/
  public static void main(String[] args) throws Exception {
    // Check command line parameter usage
    checkArgLength(args);
    // Check if source file exists
    File sourceFile = checkSrcFile(args); 
    
    StringBuilder buffer = new StringBuilder();
    
    Scanner input = new Scanner(sourceFile);
    
    while (input.hasNext()) {
      String s = input.nextLine();
      String s1 = s.trim();
      if (s1.charAt(0) == '{') {
        buffer.append(" {");
        if (s1.length() > 1) buffer.append("\r\n" + s.replace('{', ' '));
      }
      else
        buffer.append("\r\n" + s);
    }
    input.close();
    // Write buffer into the file
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(buffer.toString());
    output.close();
  }
  
  private static void checkArgLength(String[] args) { 
    if (args.length != 1) {
      System.out.println(
        "Usage: java Exercise12_12 filename");
      System.exit(1);
    }
  }
  
  private static File checkSrcFile(String[] args) { 
    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
      System.out.println("Source file " + args[0] + " not exist");
      System.exit(2);
    }
    return sourceFile;
  }
  
  private static void formatLines(Scanner input, StringBuilder buffer) { 
    while (input.hasNext()) {
      String line = input.nextLine();
      moveBracesUp(buffer, line, buffer.toString());
    }
  }
  
  private static void moveBracesUp(StringBuilder buffer, String Str1, String Str2) { 
    String trimmed = buffer.toString().trim();
    if (Str2.charAt(0) == '{') {
      buffer.append(" {");
      if (Str2.length() > 1) buffer.append("\r\n" + Str1.replace('{', ' '));
    }
    else
      buffer.append("\r\n" + Str1);
  }
  
  private static void newPrintWriterFile(File sourceFile, String newJava) throws FileNotFoundException { 
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(newJava.toString());
    output.close();
  }
  
}