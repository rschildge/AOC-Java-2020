import java.util.Arrays;
public class Day11 extends Day {
    Day11() {
        inputFile = "days/Day11/input11.txt";
    }

    public void part1(){
      String input = this.getInput();
      String [] lines = input.split("\n");
      String [] data = new String[lines.length+2];
      char[] chars = new char[lines[0].length()+2];
      Arrays.fill(chars, ' ');
      String emptyLine = new String(chars);
      data[0] = emptyLine;
      data[data.length-1]=emptyLine;
      for (int i=0;i<lines.length;i++){
        data[i+1]=" " + lines[i] + " ";
      }
      int [][]neighbors = new int[lines.length][lines[0].length()];
      boolean change = true;
      while (change){
        change = false;
        for (int row=1;row<data.length-1;row++ ){
          for (int col=1;col<data[0].length()-1;col++){
            int neighborCount =0;
            if (data[row-1].charAt(col-1)=='#'){
              neighborCount++;
            }
            if (data[row-1].charAt(col)=='#'){
              neighborCount++;
            }
            if (data[row-1].charAt(col+1)=='#'){
              neighborCount++;
            }
            if (data[row].charAt(col-1)=='#'){
              neighborCount++;
            }
            if (data[row].charAt(col+1)=='#'){
              neighborCount++;
            }
            if (data[row+1].charAt(col-1)=='#'){
              neighborCount++;
            }
            if (data[row+1].charAt(col)=='#'){
              neighborCount++;
            }
            if (data[row+1].charAt(col+1)=='#'){
              neighborCount++;
            }
            neighbors[row-1][col-1]=neighborCount;
          }
        }
        for (int row=0;row<neighbors.length;row++){
          for (int col=0;col<neighbors[0].length;col++){
            if (neighbors[row][col] == 0 && data[row+1].charAt(col+1)=='L'){
              change = true;
              data[row+1]=data[row+1].substring(0,col+1)+"#"+data[row+1].substring(col+2);
            }
            if (neighbors[row][col] >= 4 && data[row+1].charAt(col+1)=='#'){
              change = true;
              data[row+1]=data[row+1].substring(0,col+1)+"L"+data[row+1].substring(col+2);
            }
          }
        }
      }
      int count =0;
      for (int row=0;row<data.length;row++){
          for (int col=0;col<data[0].length();col++){
            if (data[row].charAt(col)=='#'){
              count++;
            }
          }
      }
        System.out.println("Count of occupied seats: "+count);
    }
    
    

    public void part2() {
      String input = this.getInput();
      String [] lines = input.split("\n");
      String [] data = new String[lines.length+2];
      char[] chars = new char[lines[0].length()+2];
      Arrays.fill(chars, ' ');
      String emptyLine = new String(chars);
      data[0] = emptyLine;
      data[data.length-1]=emptyLine;
      //System.out.println("Data[0] holds:"+data[0]+".");
      for (int i=0;i<lines.length;i++){
        data[i+1]=" " + lines[i] + " ";
      }
      int [][]neighbors = new int[lines.length][lines[0].length()];
      boolean change = true;
      int totalTimes =0;
      while (change){
        change = false;
        for (int row=1;row<data.length-1;row++ ){
          for (int col=1;col<data[0].length()-1;col++){
            int neighborCount =0;
            int distance =1;
            while (data[row-distance].charAt(col-distance)!=' ' && data[row-distance].charAt(col-distance)!='L'){
              if((data[row-distance].charAt(col-distance)=='#')){
                neighborCount++;
                break;
              }
              distance++;
            }
            distance =1;
            while (data[row-distance].charAt(col)!=' ' && data[row-distance].charAt(col)!='L'){
              if (data[row-distance].charAt(col)=='#'){
              neighborCount++;
              break;
              }
              distance++;
            }
            distance =1;
            while (data[row-distance].charAt(col+distance)!=' ' && data[row-distance].charAt(col+distance)!='L'){
              if (data[row-distance].charAt(col+distance)=='#'){
              neighborCount++;
              break;
              }
              distance++;
            }
            distance = 1;
            while (data[row].charAt(col-distance)!=' '&& data[row].charAt(col-distance)!='L'){
              if (data[row].charAt(col-distance)=='#'){
              neighborCount++;
              break;
              }
               distance++;
            }
            distance = 1;
            while (data[row].charAt(col+distance)!=' '&& data[row].charAt(col+distance)!='L'){
              if (data[row].charAt(col+distance)=='#'){
              neighborCount++;
              break;
              }
              distance++;
            }
            distance = 1;
            while (data[row+distance].charAt(col-distance)!=' ' && data[row+distance].charAt(col-distance)!='L'){
              if (data[row+distance].charAt(col-distance)=='#'){
              neighborCount++;
              break;
              }
              distance++;
            }
            distance = 1;
            while (data[row+distance].charAt(col)!=' '&& data[row+distance].charAt(col)!='L'){
              if (data[row+distance].charAt(col)=='#'){
              neighborCount++;
              break;
              }
              distance++;
            }
            distance = 1;
            while (data[row+distance].charAt(col+distance)!=' '&& data[row+distance].charAt(col+distance)!='L'){
              if (data[row+distance].charAt(col+distance)=='#'){
              neighborCount++;
              break;
              }
              distance++;
            }
            neighbors[row-1][col-1]=neighborCount;
          }
          if (totalTimes<3)
          System.out.println(data[row]);
        }
        totalTimes++;
        for (int row=0;row<neighbors.length;row++){
          for (int col=0;col<neighbors[0].length;col++){
            if (neighbors[row][col] == 0 && data[row+1].charAt(col+1)=='L'){
              change = true;
              data[row+1]=data[row+1].substring(0,col+1)+"#"+data[row+1].substring(col+2);
            }
            if (neighbors[row][col] >= 5 && data[row+1].charAt(col+1)=='#'){
              change = true;
              data[row+1]=data[row+1].substring(0,col+1)+"L"+data[row+1].substring(col+2);
            }
          }
        }
        System.out.println(change);
      }
      int count =0;
      for (int row=0;row<data.length;row++){
          for (int col=0;col<data[0].length();col++){
            if (data[row].charAt(col)=='#'){
              count++;
            }
          }
          
      }
        System.out.println("Count of occupied seats: "+count);
    }
}