package algorithm.nowcoder;

import java.util.*;

/**
 *
 */
public class DeleteFileTree {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int len = Integer.valueOf(scanner.nextLine());
            Map<Integer, Integer> map = new TreeMap<>();
            for(int i=0; i<len; i++){
                String str = scanner.nextLine();
                map.put(Integer.valueOf(str.split(" ")[0]), Integer.valueOf(str.split(" ")[1]));
            }
            int delete = Integer.valueOf(scanner.nextLine());
            List<Integer> allChildren = findAllChild(delete, map);
            allChildren.forEach((t)->{
                map.remove(t, map.get(t));
            });
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() != 0){
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }

            }
        }
    }

    private static List<Integer> findAllChild(int pid, Map<Integer, Integer> map){
        List<Integer> res = new ArrayList<>();
        res.add(pid);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == pid){
                res.add(entry.getKey());
                findAllChild(entry.getKey(), map);
            }
        }
        return res;
    }
}
