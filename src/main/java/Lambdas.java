import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;

@FunctionalInterface
public interface Lambdas<T,R> {
    R process(T str);
}

class Test {
    public static void main(String[] args) {
        Lambdas<String, String> lambdas = (String str)->str+str;
        System.out.println(lambdas.process("abc"));

        Thread thread = new Thread(() -> {int a = 2+3;} );
        testFunc(5, (int y) -> {
        });
    }

    public <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T t: list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static void testFunc(int x, IntConsumer dealWithResult) {
        System.out.println(x);
    }
}
