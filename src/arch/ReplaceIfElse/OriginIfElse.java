package arch.ReplaceIfElse;

/**
 * 根据不同的serviceType处理不同业务逻辑
 */
public class OriginIfElse {
    public void methodIfElse(String resourceType){
        switch (resourceType){
            case "wallet":
                System.out.println("dispatching wallet");
            case "coupon":
                System.out.println("dispatching coupon");
            case "point":
                System.out.println("dispatching point");
        }
    }
}

