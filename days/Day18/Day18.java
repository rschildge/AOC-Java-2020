import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
public class Day18 extends Day {
    String [] lines;
    String input;
    Day18() {
        inputFile = "days/Day18/input18.txt";
    }
    public void part1(){
      input = this.getInput();
      lines = input.split("\n");
      for(int i=0;i<lines.length;i++){
        while (lines[i].indexOf("(")!= -1){
          lines[i]=solveNextParentheses(lines[i], 0);
        }
        while (lines[i].indexOf("+")!= -1 || lines[i].indexOf("*")!= -1){
          lines[i]=doNextNumbers(lines[i]);
        }
        System.out.println("Line "+i+":" + lines[i]+"\n");
      }
      long sum = 0;
      for(String line:lines){
        sum+= Long.parseLong(line);
      }
      System.out.println("Sum: "+sum);
    }

    String solveNextParentheses(String line, int index){
        int start = -1;
        int end = -1;
        for (int i=0;i<line.length();i++){
          if (line.charAt(i)=='('){
            start = i;
          }
          else if(line.charAt(i)==')'){
            end =i;
            break;
          } 
        }
        return line.substring(0,start)+doNextNumbers(line.substring(start+1,end))+line.substring(end+1);
    }



    String doNextNumbers(String line){
      // keep doing the math until you hit the end of line
      int nextSpace = line.indexOf(" ");
      if (nextSpace==-1) 
        return line;
      while(nextSpace!=-1){
        System.out.println("Initial Line:"+line);
        // Copy and remove first number
        long firstNumber = Long.parseLong(line.substring(0,nextSpace));
        line = line.substring(nextSpace + 1);
        System.out.println("First number gone:"+line);
        // Copy and remove operation
        char op = line.charAt(0);
        line = line.substring(2);
        System.out.println("Operand gone:"+line);
        // Copy and remove second number
        nextSpace = line.indexOf(" ");
        long secondNumber = 0;
        if (nextSpace != -1){
          secondNumber = Long.parseLong(line.substring(0,nextSpace));
          line = line.substring(nextSpace);
        }
        else {
          secondNumber = Long.parseLong(line.substring(0));
          line = "";
        }
        System.out.println("Second number gone:"+line);
        if (op == '+'){
          line = (firstNumber+secondNumber) + line;
        }
        if (op == '*'){
          line = (firstNumber*secondNumber) + line;
        }
        nextSpace = line.indexOf(" ");
      }
      return line;

    }
//(5 * 9 + 3 + 2) + 4 + 7
//297 should read 81 (currently reads 65)
//5*14!=54
    public void part2(){
      input = this.getInput();
      lines = input.split("\n");
      for(int i=0;i<lines.length;i++){
        while (lines[i].indexOf("(")!= -1){
          lines[i]=solveNextParentheses2(lines[i], 0);
        }
        System.out.println("No Parentheses:"+lines[i]);
        while (lines[i].indexOf("+")!= -1 || lines[i].indexOf("*")!= -1){
          lines[i]=doNextNumbers2(lines[i]);
        }
      System.out.println("Line "+i+":" + lines[i]+"\n");
      }
      long sum = 0;
      for(String line:lines){
        sum+= Long.parseLong(line);
      }
      System.out.println("Sum: "+sum);

      // Not 249494074088700 (too low)
    }

      String solveNextParentheses2(String line, int index){
        int start = -1;
        int end = -1;
        for (int i=0;i<line.length();i++){
          if (line.charAt(i)=='('){
            start = i;
          }
          else if(line.charAt(i)==')'){
            end =i;
            break;
          } 
        }
        return line.substring(0,start)+doNextNumbers2(line.substring(start+1,end))+line.substring(end+1);
    }

    String doNextNumbers2(String line){
      //find additions
      int nextAddition = line.indexOf(" + ");
      while (nextAddition!=-1){
        //find prior number
        int startIndex = nextAddition - 1;
        while (startIndex > 0 && line.charAt(startIndex-1)!= ' '){
          startIndex -= 1;
        }
        long first = Long.parseLong(line.substring(startIndex,nextAddition));
        //find second number
        int endIndex = nextAddition + 4;
        while (endIndex < line.length() && line.charAt(endIndex)!= ' '){
          endIndex += 1;
          //System.out.println("Added one");
        }
        //System.out.println(line.substring(nextAddition+3, endIndex));
        long second = Long.parseLong(line.substring(nextAddition+3, endIndex));
        //add them
        long sum = first + second;
        //replace 
        line = line.substring(0,startIndex) + sum + line.substring(endIndex);
        //System.out.println(line);
        nextAddition = line.indexOf(" + ");
      }
      System.out.println("No more addition:" + line);
      //find multiplications
      int nextMult = line.indexOf(" * ");
      while (nextMult!=-1) {
        //find prior number
        int startIndex = nextMult - 1;
        while (startIndex > 0 && line.charAt(startIndex-1)!= ' '){
          startIndex -= 1;
        }
        long first = Long.parseLong(line.substring(startIndex,nextMult));
        //find second number
        int endIndex = nextMult + 4;
        while (endIndex < line.length() && line.charAt(endIndex)!= ' '){
          endIndex += 1;
        }
        long second = Long.parseLong(line.substring(nextMult+3, endIndex));
        //add them
        long sum = first * second;
        //replace 
        line = line.substring(0,startIndex) + sum + line.substring(endIndex);
        nextMult = line.indexOf(" * ");
      }
      System.out.println("No more multiplication:" + line);
      return line;
    }

}