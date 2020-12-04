public class Day3 extends Day {
    Day3() {
        inputFile = "days/Day3/input3.txt";
    }

    public void part1() {
      String input = this.getInput();
      int index = 0;
      int answer = 0;
      String [] lines = input.split("\n");
      for (int row = 1;row < lines.length;row++ ) {
        index = (index + 3) % lines[row].length();
        if (lines[row].charAt(index)=='#') answer++;
      }
      System.out.println(String.format("Answer: %d", answer));
    }

    public void part2() {
      String input = this.getInput();
      int index = 0;
      long answer1 = 0;
      long answer2 = 0;
      long answer3 = 0;
      long answer4 = 0;
      long answer5 = 0;
      String [] lines = input.split("\n");
      for (int row = 1;row < lines.length;row++ ) {
        index = (index + 1) % lines[row].length();
        if (lines[row].charAt(index)=='#') answer1++;
      }
      index = 0;
      for (int row = 1;row < lines.length;row++ ) {
        index = (index + 3) % lines[row].length();
        if (lines[row].charAt(index)=='#') answer2++;
      }
      index = 0;
      for (int row = 1;row < lines.length;row++ ) {
        index = (index + 5) % lines[row].length();
        if (lines[row].charAt(index)=='#') answer3++;
      }
      index = 0;
      for (int row = 1;row < lines.length;row++ ) {
        index = (index + 7) % lines[row].length();
        if (lines[row].charAt(index)=='#') answer4++;
      }
      index = 0;
      for (int row = 2;row < lines.length;row+=2 ) {
        index = (index + 1) % lines[row].length();
        if (lines[row].charAt(index)=='#') answer5++;
      }
      long result = answer1*answer2*answer3*answer4*answer5;
      System.out.println(String.format("Answer: "+ result));
      System.out.println(String.format("Answers: %d %d %d %d %d", answer1,answer2,answer3,answer4,answer5));
    }
}