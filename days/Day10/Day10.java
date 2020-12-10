
import java.util.Arrays;
public class Day10 extends Day {
    Day10() {
        inputFile = "days/Day10/input10.txt";
    }
    int total=0;
    int nums [];
    public void part1(){}
    public void part2() {
      String input = this.getInput();
      int index = 0;
      int answer = 0;
      String [] lines = input.split("\n");
      nums = new int[lines.length];
      for (int i=0;i<lines.length;i++){
        nums[i]=Integer.parseInt(lines[i]);
      }
      Arrays.sort(nums);
      /*for (int i=0;i<lines.length;i++){
        System.out.println(nums[i]);
      }
      */
    doThing(0);
    System.out.println("Total is: "+total);

    }

    void doThing(int index){
      if (index == nums.length-1){
        total++;
        System.out.print(total+" ");
        return;
      }
 
      while (index < nums.length && nums[index+1]-nums[index] > 0 && nums[index+1]-nums[index] <4 ){
        doThing(index);
        index++;
      }
    }
}

/*Zero is tenletters (0)
let total be Zero
let lastIndex be the journey without pain

doThing takes index, path
rock path with the journey at index
if index is lastIndex
build total up
join path with ";"
shout path
give back nothing
 
Four is four
Let currentNumber be the journey at index
build index up
Let nextNumber be the journey at index
Let diff be nextNumber without currentNumber
while diff is less than four and diff is greater than Zero and index is as small as lastIndex
doThing taking index, path
Let currentNumber be the journey at index
build index up
Let nextNumber be the journey at index
Let diff be nextNumber without currentNumber

shout diff is less than four
Give back nothing


Rock the path
doThing taking Zero, the path
shout "Total: " plus total
*/