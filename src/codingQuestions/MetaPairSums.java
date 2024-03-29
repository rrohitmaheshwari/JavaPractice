/*
Pair Sums

Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different if one pair includes at least one array index which the other doesn't, even if they include the same values.

Example 1
n = 5
k = 6
arr = [1, 2, 3, 4, 3]
output = 2
The valid pairs are 2+4 and 3+3.

Example 2
n = 5
k = 6
arr = [1, 5, 3, 3, 3]
output = 4

*/

import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  

  int numberOfWays(int[] arr, int k) {
    // Write your code here
    HashMap<Integer,Integer> hm = new HashMap<>();
    
    for(int i:arr)
    {
      hm.put(i,hm.getOrDefault(i,0)+1);
    }
    
    System.out.println(hm);
    
    int cnt = 0;
    
    for(Map.Entry<Integer,Integer> en:hm.entrySet())
    {
      
      if(hm.containsKey(Math.abs(k-en.getKey())))
      {
            if(k-en.getKey() == en.getKey())
            {
              cnt = cnt + en.getValue()*(hm.get(k-en.getKey())-1);
            }
            else
            {
              cnt = cnt + en.getValue()*hm.get(k-en.getKey());
            }
      }
    }
    
    return cnt/2;
    
  }


  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  
  public void run() {
    int k_1 = 6;
    int[] arr_1 = {1, 2, 3, 4, 3};
    int expected_1 = 2;
    int output_1 = numberOfWays(arr_1, k_1);
    check(expected_1, output_1);

    int k_2 = 6;
    int[] arr_2 = {1, 5, 3, 3, 3};
    int expected_2 = 4;
    int output_2 = numberOfWays(arr_2, k_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new Main().run();
  }
}