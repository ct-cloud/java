package arch.ReplaceIfElse;

public class Context<T> {
    private Strategy<T> strategy;
    Context(Strategy strategy){
        this.strategy = strategy;
    }

    public T contextInterface(){
        return this.strategy.query();
    }
}
