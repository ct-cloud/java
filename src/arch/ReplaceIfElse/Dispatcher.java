package arch.ReplaceIfElse;

import java.util.function.Function;

public class Dispatcher {
    public Function<String, String> dispatchCoupon = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return "dispatch coupon" + s;
        }
    };

    public String dispatchPoint(String resourceId){
        return "dispatch point" + resourceId;
    }
}
