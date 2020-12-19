import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Day15 extends Day {
    Day15() {
        inputFile = "days/Day15/input15.txt";
    }

    public void part1(){
      ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,0,18,10,19,6));
      for (int i=nums.size()-1;i<2020;i++){
        int index = nums.subList(0,i).lastIndexOf(nums.get(i));
        if (index == -1){
          nums.add(0);
        }
        else {
          nums.add(i-index);
        }
      }
      System.out.println(nums.get(2019));
    }
    public void part2b(){
      ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,0,18,10,19,6));
      for (int i=nums.size()-1;i<30000000;i++){
        int index = nums.subList(0,i).lastIndexOf(nums.get(i));
        if (index == -1){
          nums.add(0);
        }
        else {
          nums.add(i-index);
        }
      }
      System.out.println(nums.get(30000000 - 1));
    }

    public void part2(){
      HashMap<Integer, Integer> nums = new HashMap<>(65536,.75f);
      nums.put(1,0);
      nums.put(0,1);
      nums.put(18,2);
      nums.put(10,3);
      nums.put(19,4);
      int prevValue = 6;
      for (int i=nums.size();i<30000000;i++){
        Integer index = nums.get(prevValue);
        nums.put(prevValue,i);
        if (index == null){
          prevValue = 0;
        }
        else {
          prevValue =i-index-1;
        }
        if (i==30000000-1){
          System.out.println(prevValue);
        }
      }
    }
    //not 134107 too low
}