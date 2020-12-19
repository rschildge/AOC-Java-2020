import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
public class Day16 extends Day {
    ArrayList <String> validLines = new ArrayList<>();
    ArrayList <TicketField> solution = new ArrayList<>();
    ArrayList <TicketField> fields = new ArrayList<>();
    String [] lines;
    String input;
    Day16() {
        inputFile = "days/Day16/input16.txt";
    }

    public void part1(){
      input = this.getInput();
      lines = input.split("\n");
      int i =0;
      // FILL FIELDS ARRAYLIST WITH TICKETFIELD OBJECTS
      while (lines[i].length()>0){
        //System.out.println(lines[i]);
        int minA = Integer.parseInt(lines[i].substring(lines[i].indexOf(":")+2,lines[i].indexOf("-")));
        int maxA = Integer.parseInt(lines[i].substring(lines[i].indexOf("-")+1,lines[i].indexOf(" or ")));
        int minB = Integer.parseInt(lines[i].substring(lines[i].indexOf(" or ")+4,lines[i].lastIndexOf("-")));
        int maxB = Integer.parseInt(lines[i].substring(lines[i].lastIndexOf("-")+1));
        String name = lines[i].substring(0,lines[i].indexOf(":"));
        //System.out.println(name);
        fields.add(new TicketField(minA, maxA, minB, maxB,name));
        i++;
      }
      i+=5;
      int sum=0;
      //ADD VALID LINES TO VALIDLINES ARRAYLIST
      for (;i<lines.length;i++){
        //System.out.println(lines[i]);
        String [] line = lines[i].split(",");
        boolean validLine=true;
        for (String data : line){
          boolean isValid = false;
          int num = Integer.parseInt(data);
          for (TicketField t:fields){
            if (t.isValid(num)==true){
              isValid = true;
            }
          }
          if (isValid == false) {
            sum+= num;
            validLine=false;
          }
        }
        if (validLine){
          validLines.add(lines[i]);
        }
      }
      System.out.println("Total sum: " + sum + "\nValid lines: "+ validLines.size());
      // not 119064 too high
      //29019 correct
      validLines.add(lines[22]);
    }
    
    public void part2(){
      String[]options= new String[20];
      for(int i=0;i<20;i++) options[i]=""; 
      for(int i=0;i<fields.size();i++){
          for (int col=0;col<20;col++){
            boolean valid = true;
            for (int p=0;p<validLines.size();p++){
              String [] line = validLines.get(p).split(",");
              if (!fields.get(i).isValid(Integer.parseInt(line[col]))){
                valid=false;
              }
            }
            if (valid==true){
              options[col]+=fields.get(i).name+"/";
              //solution.set(col,fields.get(i));
              //fields.set(i,null);
            }
          }
        }
        for(int i=0;i<20;i++){
          //System.out.println(i + ":"+options[i]);
          options[i]=options[i].substring(0,options[i].length()-1);
        }
        String []answer=new String[20];
        for(int i=0;i<20;i++){
          int location = -1;
          for(int p=0;p<20;p++){
            if (!options[p].equals("") && options[p].indexOf("/")==-1){
              location = p;
            }
          }
          answer[location]=options[location];
          //System.out.println("Found "+location+": -"+options[location]+"-");
          
          for(int p=0;p<20;p++){
            int loc=options[p].indexOf(answer[location]);
            if (loc!=-1){
              options[p]=options[p].substring(0,loc) + options[p].substring(loc+answer[location].length());
              options[p]=options[p].replace("//","/");
              if(options[p].length()>0 && options[p].charAt(0)=='/'){
                options[p]=options[p].substring(1);
              }
              if(options[p].length()>0 && options[p].charAt(options[p].length()-1)=='/'){
                options[p]=options[p].substring(0,options[p].length()-1);
              }
            }
          }
        }
        long product =1;
        String [] myData = lines[22].split(",");
        for(int i=0;i<20;i++){
          //System.out.println(i + ":"+options[i]);
          if (answer[i].indexOf("departure")!=-1){
            product *= Integer.parseInt(myData[i]);
          }
        }
      System.out.println("Product: " + product);

    }
    public void part2b(){ //20 fields
      
      outer:
      for(int colStart =0;colStart<20;colStart++){ 
      for(int f=0;f<fields.size();f++){
        solution.clear();
        for (int i=0;i<20;i++){
          solution.add(null);
        }
        for(int w=0;w<fields.size();w++){
          int i = (f + w)%20;
          inner:
          for (int y=0;y<20;y++){
            int col = (colStart + y) %20;
            boolean valid = true;
            for (int p=0;p<validLines.size();p++){
              String [] line = validLines.get(p).split(",");
              if (!fields.get(i).isValid(Integer.parseInt(line[col]))){
                valid=false;
              }
            }
            if (valid==true){
              solution.set(col,fields.get(i));
              //fields.set(i,null);
              break inner;
            }
          }
        }
        boolean found = true;
        for (int i=0;i<20;i++){
          TicketField t = solution.get(i);
          if (t==null){
            found = false;
          }
        }
        if (found) break outer;
        System.out.println(colStart + " " +f);
      }
    }
    for (int i=0;i<20;i++){
        solution.get(i).print();
    }
    long product = 1;
    String [] myData = lines[22].split(",");
    for (int i=0;i<myData.length;i++){
      //System.out.println(solution.get(i).name);
      if (solution.get(i).name.indexOf("departure")!=-1){
        product*=Integer.parseInt(myData[i]);
      }
    }
    System.out.println("Product: "+ product);
  }
}