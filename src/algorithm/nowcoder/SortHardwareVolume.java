package algorithm.nowcoder;

import java.util.*;

/**
 * 2G10T2M2G  磁盘大小字符串
 * 按从大到小排列
 */
public class SortHardwareVolume {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int len = Integer.parseInt(scanner.nextLine());
            PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return getVolume(o2) - getVolume(o1);
                }
            });
            for (int i = 0; i < len; i++) {
                String str = scanner.nextLine();
                priorityQueue.offer(str);
            }
            for (int i = 0; i < len; i++) {
                System.out.println(priorityQueue.poll());
            }
        }
    }

    private static int getVolume(String str){
        int volume = 0;
        int start = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'T' || str.charAt(i) == 'G' || str.charAt(i)=='M'){
                int num = Integer.valueOf(str.substring(start, i));
                start = i + 1;
                if(str.charAt(i) == 'T'){
                    volume += 1024 * 1024 * num;
                }else if(str.charAt(i) == 'G'){
                    volume += 1024 * num;
                }else if(str.charAt(i) == 'M'){
                    volume += num;
                }
            }
        }
        return volume;
    }
}
