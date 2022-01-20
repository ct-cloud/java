package arch.ReplaceIfElse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UseFuncInterfaceInStead {
    private static Map<String, Function<String, String>> serviceTypeFunc = new HashMap<>();
    private static Dispatcher dispatcher;

    UseFuncInterfaceInStead(Dispatcher dispatcher){
        System.out.println("constructor...");
        this.dispatcher = new Dispatcher();
        init();
    }

    private void init() {
        serviceTypeFunc.put("wallet", resourceId -> {return "dispatch wallet " + resourceId;});
        serviceTypeFunc.put("coupon", dispatcher.dispatchCoupon);
        serviceTypeFunc.put("point", resourceId -> dispatcher.dispatchPoint(resourceId));
    }

    public static String method (String serviceType, String serviceId){
        return serviceTypeFunc.get(serviceType).apply(serviceId);
    }

    public static void main(String [] args){
        UseFuncInterfaceInStead f = new UseFuncInterfaceInStead(new Dispatcher());
        System.out.println(f.method("wallet", "a"));
        System.out.println(f.method("coupon", "b"));
        System.out.println(f.method("point", "c"));
    }
}
