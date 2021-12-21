package algorithm.nowcoder;

import java.util.Scanner;

public class UnifyStringBy8{
    private static final int UNIFY_LEN = 8;
    public static void a(String [] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            int row = str.length() / UNIFY_LEN;
            int col = str.length() % UNIFY_LEN;
            int i=0;
            for(; i<row; i++){
                System.out.println(str.substring(UNIFY_LEN*i, UNIFY_LEN*(i+1)));
            }
            if(col > 0) {
                String append = "";
                for (int j = 0; j < UNIFY_LEN - col; j++) {
                    append += "0";
                }
                System.out.println(str.substring(UNIFY_LEN * i, str.length()) + append);
            }
        }
    }

    /**
     * 补0法
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sBuffer = new StringBuffer();
        while (in.hasNextLine()) {
            sBuffer.setLength(0);
            sBuffer.append(in.nextLine());
            sBuffer.append("00000000");
            for(int i=0; (i + 8) <= sBuffer.length(); i+=8){
                System.out.println(sBuffer.substring(i, i + 8));
            }
        }
    }
}