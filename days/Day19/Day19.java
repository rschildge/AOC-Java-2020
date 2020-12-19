import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
public class Day19 extends Day {
    String [] rules;
    String input;
    Day19() {
        inputFile = "days/Day19/input19.txt";
    }
    public void part1(){
      String input = this.getInput();
      String[] lines = input.split("\n");
      for(int i=0;i<138;i++){
        rules[i]=lines[i];
      }
      
    }

    public void part2(){
    }
}