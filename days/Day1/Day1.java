public class Day1 extends Day {
    Day1() {
        inputFile = "days/Day1/input1.txt";
    }

    public void part1() {
      String input = this.getInput();
      int answer = 0;
      for (String line1 : input.split("\n")) {
          int num1 = Integer.parseInt(line1);
          for (String line2 : input.split("\n")){
            int num2 = Integer.parseInt(line2);
            if (num1 + num2 == 2020){
              answer = num1 * num2;
            }
          }
        }
        System.out.println(String.format("Answer: %d", answer));
    }

    public void part2() {
        String input = this.getInput();
      int answer = 0;
      outer:
      for (String line1 : input.split("\n")) {
          int num1 = Integer.parseInt(line1);
          for (String line2 : input.split("\n")){
            int num2 = Integer.parseInt(line2);
            for (String line3 : input.split("\n")){
              int num3 = Integer.parseInt(line3);
              if (num1 + num2 + num3== 2020){
                answer = num1 * num2 * num3;
                break outer;
              }
            }
          }
        }
        System.out.println(String.format("Answer: %d", answer));
    }
}