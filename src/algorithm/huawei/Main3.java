import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            int lenToRv = Integer.valueOf(scanner.nextInt());
            getMinValueByRvN(str, lenToRv);
        }
    }

    private static void getMinValueByRvN(String str, int lenToRv){
        char [] arr = str.toCharArray();
        int len = str.length();
        int remain = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<arr.length-1; i++){

        }
        StringBuffer stringBuffer = new StringBuffer();
        stack.forEach((t) -> stringBuffer.append(t));
        System.out.println(Integer.valueOf(stringBuffer.toString()));
    }
}
