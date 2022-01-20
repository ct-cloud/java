package arch.ReplaceIfElse;

public class Test {
    public static void main(String [] args){
        UseFuncInterfaceInStead f = new UseFuncInterfaceInStead(new Dispatcher());
        System.out.println(f.method("wallet", "a"));
        System.out.println(f.method("coupon", "b"));
        System.out.println(f.method("point", "c"));
    }
}
