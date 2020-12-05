import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class Day5 extends Day {
    Day5() {
        inputFile = "days/Day5/input5.txt";
    }

    public void part1() {
      String input = this.getInput();
      int index = 0;
      int answer = 0;
      String [] lines = input.split("\n");
      int maxId = 0;
      ArrayList<Integer> seats = new ArrayList<>();
      for (int i = 0;i < lines.length;i++ ){
        int row = seatFinder(0,127,lines[i],'F','B');
        //System.out.print(row);
        int seat = seatFinder(0,7,lines[i].substring(7),'L','R');
        //System.out.println(" "+seat);
        int id = row * 8 + seat;
        seats.add(id);
        if (id>maxId) maxId=id;
      }
      System.out.println("Max SeatId: "+maxId);
      Collections.sort(seats);
      System.out.println(seats);
      for(int i=1;i<seats.size();i++){
        if (seats.get(i-1)+2==seats.get(i)){
          System.out.println("Seat: " + seats.get(i-1)+1);
        }
      }
    }

    private int seatFinder(int lower, int upper, String code, char a, char b){
      if(lower==upper)
        return lower;
      if(code.charAt(0)==a)
        return seatFinder(lower,lower+(upper-lower)/2,code.substring(1),a,b);
      if(code.charAt(0)==b)
        return seatFinder(lower+(upper-lower)/2+1, upper,code.substring(1),a,b);
      System.out.println(code.charAt(0)+ " " + lower+ " " + upper);
      return -1;
    }
    

     public void part2() {
      //see part 1
    }
}