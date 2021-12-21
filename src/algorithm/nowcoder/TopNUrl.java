package algorithm.nowcoder;

import java.util.*;

/**
 * 统计访问topN的url
 */
public class TopNUrl {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap();

        while (scanner.hasNext()){
            String str = scanner.nextLine();
            int topN = 0;
            try{
                topN = Integer.parseInt(str);
                StringBuffer stringBuffer = new StringBuffer();
                PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> hashMap.get(o2)-hashMap.get(o1));
                for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
                    priorityQueue.offer(entry.getKey());
                }
                for(int i=0; i<topN; i++){
                    stringBuffer.append(priorityQueue.poll() + ",");
                }
                System.out.println(stringBuffer.toString());
            }catch (NumberFormatException e){
                hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
            }

        }
    }

}
