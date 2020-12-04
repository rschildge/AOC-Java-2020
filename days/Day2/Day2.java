public class Day2 extends Day {
    Day2() {
        inputFile = "days/Day2/input2.txt";
    }

    public void part1() {
      String input = this.getInput();
      int answer = 0;
      for (String line1 : input.split("\n")) {
          int dashIndex =line1.indexOf("-");
          int spaceIndex =line1.indexOf(" ");
          int colonIndex= line1.indexOf(":");
          char letter = line1.charAt(spaceIndex+1);
          int min = Integer.parseInt(line1.substring(0,dashIndex));
          int max = Integer.parseInt(line1.substring(dashIndex+1,spaceIndex));
          String password = line1.substring(colonIndex+2);
          int n = (int) password.chars().filter(ch -> ch == letter).count();
          if (n >= min && n <= max) answer++;
      }
        
        System.out.println(String.format("Answer: %d", answer));
    }

    public void part2() {
      String input = this.getInput();
      int answer = 0;
      for (String line1 : input.split("\n")) {
          int dashIndex =line1.indexOf("-");
          int spaceIndex =line1.indexOf(" ");
          int colonIndex= line1.indexOf(":");
          char letter = line1.charAt(spaceIndex+1);
          int a = Integer.parseInt(line1.substring(0,dashIndex));
          int b = Integer.parseInt(line1.substring(dashIndex+1,spaceIndex));
          String password = line1.substring(colonIndex+2);
          System.out.println(line1 + " "  + a + " " + b + " " + password.length() + password);
          if ( ((password.charAt(a-1)==letter && password.charAt(b-1) != letter) || (password.charAt(a-1)!=letter && password.charAt(b-1) == letter))) answer++;
          
      }
        
        System.out.println(String.format("Answer: %d", answer));
    }
}