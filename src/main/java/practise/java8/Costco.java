package practise.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Costco {

    public static void main(String[] args) {
        String[] a = {"ST1", "ST2", "ST3", "ST4", "ST5", "ST6"};
Arrays.stream(a).collect(Collectors.groupingBy
        (Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().forEach(System.out::println);

Arrays.stream(a).collect(Collectors.groupingBy(Function.identity(),
        LinkedHashMap::new,Collectors.counting()));

//        HashMap<String, Integer> mp = new HashMap<>();
//        mp.put("one", 1);
//        mp.put("two", 2);
//        mp.put("three", 3);
//        mp.put("four", 4);
//        mp.put("five", 5);
//        mp.put("six", 6);
//        mp.put("seven", 7);
//        mp.put("eight",8);
//        mp.put("nine",9);
//        mp.put("zero",0);
//        // 6+2-3-4+4+5
//        String str = "sixplustwominusthreeminusfourplusfourplusfiveminusnineminusnineminusnine";
//        String[] s1 = str.split("plus");
//        int sum = 0;
//       for(String s : s1){
//           if(s.indexOf("minus")!=-1){
//               String[] tstr = s.split("minus");
//             int tempVal = 0;
//               for(int i=0; i< tstr.length; i++){
//                   if(i==0){
//                       tempVal+=mp.get(tstr[i]);
//                   }else {
//                       tempVal-=mp.get(tstr[i]);
//                   }
//               }
//                sum=sum+tempVal;
//           }else {
//               sum+=mp.get(s);
//           }
//
//       }
//                System.out.println(sum);
   }
}
