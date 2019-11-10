package programs.strings;

import java.util.*;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 *  And then read line by line: "PAHNAPLSIIGYIR"
 *
 *  Write the code that will take a string and make this conversion given a number of rows:
 *
 *  string convert(string s, int numRows);
 *  Example 1:
 *
 *  Input: s = "PAYPALISHIRING", numRows = 3
 *  Output: "PAHNAPLSIIGYIR"
 *  Example 2:
 *
 *  Input: s = "PAYPALISHIRING", numRows = 4
 *  Output: "PINALSIGYAHRPI"
 *  Explanation:
 *
 *  P     I    N
 *  A   L S  I G
 *  Y A   H R
 *  P     I
 */
public class ZigZag {

    public static void main(String[] args) {
        String input = "ABCD";

        StringBuilder sb = new StringBuilder(input.length());
        int rows = 3;
        HashMap<Integer, ArrayList<Character>> map = new HashMap<>(rows);
        for (int i = 0; i < rows; i++) {
            ArrayList<Character> arrayList = new ArrayList<>();
            map.put(i, arrayList);
        }

        int low = 0;
        int high = input.length();
        int i = low;
        while (low <= high-1 ) {
            // handle the case of zigzag
            if (i == rows) {
                i = i - 1;
               for (int k = i; k > 0; k--) {
                    i--;
                    if (i == 0 && low<=input.length() - 1) {
                        ArrayList<Character> list = map.get(i);
                        list.add(input.charAt(low));
                        i = i + 1;
                        break;
                    } else if(i > 0 && low<=input.length() - 1){
                        ArrayList<Character> list = map.get(i);
                        list.add(input.charAt(low));
                    }
                    low++;
                }
                low++;

            } else {
                if(rows==1){ // in case row is 1 just add all elements to list at index 0;
                    while (low <= input.length() - 1) {
                        ArrayList<Character> list = map.get(i);
                        list.add(input.charAt(low));
                        low++;
                    }
                }else {
                    while (i < rows && low <= input.length() - 1) { // add all elements to list from index 0 to rows -1
                        ArrayList<Character> list = map.get(i);
                        list.add(input.charAt(low));
                        i++;
                        low++;
                    }
                }

            }

        }

        for (int m = 0; m < rows; m++) {
            ArrayList<Character> list = map.get(m);
            for(Character chr:list){
                sb.append(chr);
            }
        }
        System.out.println(sb.toString());
    }
}