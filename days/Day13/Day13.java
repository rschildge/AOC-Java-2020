  import java.util.Arrays;
  import java.math.BigInteger;
  import java.util.ArrayList;
  public class Day13 extends Day {
      Day13() {
          inputFile = "days/Day13/input13.txt";
      }

      public void part1(){
        String input = this.getInput();
        String [] lines = input.split("\n");
        int start = Integer.parseInt(lines[0]);
        String [] data= lines[1].split(",");
        ArrayList <Integer> busses = new ArrayList<>() ;
        for (int i=0;i<data.length;i++){
          if (!data[i].equals("x")){
            busses.add(Integer.parseInt(data[i]));
            //System.out.println(i + " " + data[i]);
          } 
        }
        int num = start;
        out:
        while (true){
          int lowest = Integer.MAX_VALUE;
          for(int i=0;i<busses.size();i++){
            if (num % busses.get(i) == 0){
              if (busses.get(i)<lowest);
                lowest = busses.get(i);
            }
          }
            if (lowest != Integer.MAX_VALUE){
              System.out.println(lowest * (num-start));
              break out;
            }
          num++;
          }
        
        //System.out.println(busses[0]);
      }
      public void part2(){
        String input = this.getInput();
        String [] lines = input.split("\n");
        int start = Integer.parseInt(lines[0]);
        String [] data= lines[1].split(",");
        long productOfMods =1;
        for (int i=0;i<data.length;i++){
          if (!data[i].equals("x")){
            int num = Integer.parseInt(data[i]);
            productOfMods *= num;
          } 
        }
        long answer =0;
        for (int i=0;i<data.length;i++){
          if (!data[i].equals("x")){
            int num = Integer.parseInt(data[i]);
            int b = (( -1*i) % num) + num;
            long n = productOfMods / num;
            /*
            int x = 1;
            while (true){
              if ((x * n) % num == 1 ){
                break;
              }
              x++;
            }
            */
            long x = BigInteger.valueOf(n).modInverse(BigInteger.valueOf(num)).longValue();
            answer += b*n*x;
          }
        }
        long result  = answer % productOfMods;
       System.out.println(answer);
      //not 41164711
      // not    118155204350589
      //Correct 530015546283687
      }
  }