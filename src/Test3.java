import java.util.*;

public class Test3 {
    public int solution(String S, int[] C) {
        // write your code in Java SE 11
        PriorityQueue<LinkedList<Integer>> minHeap = new PriorityQueue<>((e1, e2)->{
            return e1.peek() - e2.peek();
        });
        Map<Character, LinkedList<Integer>> freqMap = new HashMap<>();
        char[] chArr = S.toCharArray();
        for(int i = 0; i < chArr.length; i++) {
            LinkedList<Integer> indexs = freqMap.getOrDefault(chArr[i], new LinkedList<>());
            if(!indexs.isEmpty()) {
                if(indexs.getLast() + 1 == i) {
                    indexs.offer(i);
                }
            }else {
                indexs.offer(i);
            }
            freqMap.put(chArr[i], indexs);
        }

        for(Map.Entry<Character, LinkedList<Integer>> chFreq : freqMap.entrySet()) {
            LinkedList<Integer> indexs = chFreq.getValue();
            if(indexs.size() > 1) {
                LinkedList<Integer> list  = new LinkedList<>();
                for(Integer index : indexs) {

                    list.add(C[index]);
                }
                Collections.sort(list);
                minHeap.offer(list);
            }
        }
        int result = 0;
        while(!minHeap.isEmpty()) {
            LinkedList<Integer> cur = minHeap.poll();
            if(cur.size() == 1) continue;
            int cost = cur.poll();
            minHeap.offer(cur);
            result += cost;
        }

        return result;
    }
}
class Test1234 {
    public static void main(String[] args) {
        Test3 test = new Test3();
        test.solution("aaaa", new int[]{3, 4, 5, 6});
    }
}