
import java.util.Arrays;
public class Day4 extends Day {
    Day4() {
        inputFile = "days/Day4/input4.txt";
    }

    public void part1() {
      
    }
    public void part2() {
      String input = this.getInput();
      int answer = 0;
      String [] lines = input.split("\n");
      String currentPassport="";
      for (int row = 0;row < lines.length;row++ ) {
        if (!lines[row].equals("")){
          currentPassport+=" " + lines[row].substring(0,lines[row].length());
        }
        else{
          int countColons = (int)currentPassport.chars().filter(ch -> ch == ':').count();
          //System.out.println(countColons+currentPassport);
          if(countColons==8 || (countColons==7 && currentPassport.indexOf(" cid:") == -1)){
            //System.out.println(" GOOD");
            String [] data = currentPassport.split(" ");
            boolean valid = true;
            for(String d:data){
              if (d.equals("")) continue;
              if (d.substring(0,3).equals("byr")){
                if (!(d.length()==8 && d.substring(4).matches("\\d+")&&Integer.parseInt(d.substring(4))>=1920 && Integer.parseInt(d.substring(4))<=2002)){
                  valid=false;
                  //System.out.println("Invalid: " +d);
                }
                else{
                  //System.out.println("Valid: " +d);
                }
              }
              else if (d.substring(0,3).equals("iyr")){
                if (!(d.length()==8 && d.substring(4).matches("\\d+") && Integer.parseInt(d.substring(4))>=2010 && Integer.parseInt(d.substring(4))<=2020)){
                  valid=false;
                  //System.out.println("Invalid: " +d);
                }
                else{
                  //System.out.println("Valid: " +d);
                }
              }
              else if (d.substring(0,3).equals("eyr")){
                if (!(d.length()==8 && d.substring(4).matches("\\d+")&&Integer.parseInt(d.substring(4))>=2020 && Integer.parseInt(d.substring(4))<=2030)){
                  valid=false;
                  //System.out.println("Invalid: " +d);
                }
                else{
                  //System.out.println("Valid: " +d);
                }
              }
              else if (d.substring(0,3).equals("hgt")){
                if (!(((d.length()==8 ||d.length()==9) && d.substring(4,d.length()-2).matches("\\d+") && ((d.substring(d.length()-2).equals("cm") && Integer.parseInt(d.substring(4,d.length()-2))>=150 && Integer.parseInt(d.substring(4,d.length()-2))<=193)||(d.substring(d.length()-2).equals("in") && Integer.parseInt(d.substring(4,d.length()-2))>=59 && Integer.parseInt(d.substring(4,d.length()-2))<=76))))){
                  valid=false;
                  //System.out.println("Invalid: " +d);
                }
                else{
                  //System.out.println("Valid: " +d);
                }
              }
              else if (d.substring(0,3).equals("hcl")){
                if (!(((d.length()==11 && d.charAt(4)=='#') && d.substring(5).matches("-?[0-9a-f]+")))){
                  valid=false;
                  //System.out.println("Invalid: " +d);
                }
                else{
                  //System.out.println("Valid: " +d);
                }
              }
              else if (d.substring(0,3).equals("ecl")){
                String []words=new String[]{"amb","blu","brn","gry","grn","hzl","oth"};
                String text=d.substring(4);
                if (!(d.length()==7 && Arrays.asList(words).contains(text))){
                  valid=false;
                  //System.out.println("Invalid: " +d);
                }
                else{
                  //System.out.println("Valid: " +d);
                }
              }
              else if (d.substring(0,3).equals("pid")){
                if (!(((d.length()==13 && d.substring(4).matches("-?[0-9]+"))))){
                  valid=false;
                  System.out.println("Invalid: " +d);
                }
                else{
                  //System.out.println("Valid: " +d);
                }
              }
              //System.out.println(d);
            }
            if (valid)
            
            answer++;
          }
          else{
            //System.out.println(" BAD");
          }
          currentPassport="";
        }
      }
      System.out.println("Answer: " + answer);
    }
}