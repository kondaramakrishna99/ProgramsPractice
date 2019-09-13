
@FunctionalInterface
public interface CheckedFunction<T,R> {
    public R apply(T r) throws Exception;
}




