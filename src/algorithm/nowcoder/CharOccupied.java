package algorithm.nowcoder;

import java.util.*;

/**
 * a:1,b:2,c:4@a:1,c:1
 * 输出 b:2,c:3  保持输入顺序不变
 */
public class CharOccupied {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(charNotOccupied(str));
        }
    }

    private static String charNotOccupied(String str){
        String [] strArr = str.split("@");
        Map<String, Integer> inputMap = new HashMap<>();
        String [] inputStr = strArr[0].split(",");
        Map <String, Integer> occupiedMap = new HashMap<>();
        List<String> inputList = new ArrayList<>();
        Arrays.stream(inputStr).forEach((t)->{
            inputMap.put(t.split(":")[0], Integer.valueOf(t.split(":")[1]));
            inputList.add(t.split(":")[0]);
        });
        Arrays.stream(strArr[1].split(",")).forEach((t)->{
            occupiedMap.put(t.split(":")[0], Integer.valueOf(t.split(":")[1]));
        });
        for(Map.Entry<String, Integer> entry: occupiedMap.entrySet()){
            if(inputMap.containsKey(entry.getKey())){
                inputMap.put(entry.getKey(), inputMap.get(entry.getKey())-entry.getValue());
            }
        }
        StringBuffer strBuf = new StringBuffer();
        inputList.forEach((t) -> {
            if(inputMap.get(t) != 0) {
                strBuf.append(t + ":" + inputMap.get(t) + ",");
            }
        });
        String res = strBuf.toString();
        return res.substring(0, res.length()-1);
    }

}
