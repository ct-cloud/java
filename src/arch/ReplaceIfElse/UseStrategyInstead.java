package arch.ReplaceIfElse;

/**
 * 策略模式把if else不同分支封装成不同策略
 * 当分支增加时，策略类也会随之增加，没法俯视整个分派的业务逻辑
 * @param <T>
 */
public class UseStrategyInstead<T> {
    public static Object method(String serviceType){
        switch (serviceType){
            case "wallet":
                return new Context(new WalletStrategy()).contextInterface();
            case "coupon":
                return new Context(new CouponStrategy()).contextInterface();
            case "point":
                return new Context(new PointStrategy()).contextInterface();
            default:
                System.out.println("not supported service type");
        }
        return null;
    }

    public static void main(String [] args){
        System.out.println(method("wallet"));
        System.out.println(method("coupon"));
    }
}
