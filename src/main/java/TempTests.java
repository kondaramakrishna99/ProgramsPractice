
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class TempTests {

    public static void main(String[] args) {
        String str = "2x+5-3+x=6+x-2";
        String temp  = "2x+5-3+x";
        String[] strs = temp.split("(?=\\+)|(?=-)");
        int i = Integer.parseInt("-5");
        System.out.println(i);
        System.out.println(Arrays.toString(strs));
        StringTokenizer stringTokenizer = new StringTokenizer(str, "+=-", true);
        List<String> tokens = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()) {
            tokens.add(stringTokenizer.nextToken());
        }
        System.out.println(tokens.toString());

        String[] testCopy = Arrays.copyOf(strs, strs.length);
        System.out.println(Arrays.toString(testCopy));

        AtomicInteger atomicInteger = new AtomicInteger(1);
        int k = atomicInteger.getAndAdd(1);

        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(3);
            add(7);
        }};
        Set<Integer> setTemp = new HashSet<>(list);
        System.out.println("list to set: "+setTemp.toString());
        System.out.println(Collections.binarySearch(list, 0));
        System.out.println(Collections.binarySearch(list, 8));
        System.out.println(Collections.binarySearch(list, 4));
        list.add(2,4);
        System.out.println(list.toString());

        str = "/a";
        System.out.println(Arrays.toString(str.split("/")));
        System.out.println(str.substring(0,0)+" 00");
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        Deque<Integer>  deque = new LinkedList<>();

        int[] a = {1,2};
        int[] b = {1,2};
        Set<int[]> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set.size());
        System.out.println(Arrays.equals(a,b));

        List<Integer> list1= new ArrayList<Integer>(){{add(1);add(2);}};
        List<Integer> list2= new ArrayList<Integer>(){{add(1);add(2);}};
        Integer[] intArray = list1.toArray(new Integer[list1.size()]);
        System.out.println("array from list: "+Arrays.toString(intArray));
        Set<List<Integer>> setList = new HashSet<>();
        setList.add(list1);
        setList.add(list2);
        System.out.println(setList.size()+"  "+setList.toString()+"  "+list1.equals(list2));

        StringBuilder sb = new StringBuilder("abc");
        sb.append("d").deleteCharAt(0);
        sb.insert(2, 'e');
        System.out.println(sb.toString());

        Map<String, Integer> map = new HashMap<>();

        System.out.println("3%-2 => "+(3%-2)+"  1%-2=>   "+(1%-2));

        int[] testArray = {1,2,3};
        int[] copyArray  = Arrays.copyOf(testArray, testArray.length);
        System.out.println("copyarray:" + Arrays.toString(copyArray));

        String root ="/a/b";
        System.out.println(Arrays.toString(root.split("/")));

        list1= new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.sort((a1,b1)-> a1-b1);
        System.out.println(list1.toString());

        Iterator<Integer> it = list1.iterator();
        it.next();
        it.remove();
        System.out.println(it.next());
        System.out.println(list1.toString());
        set = new HashSet<>();

    }
}
