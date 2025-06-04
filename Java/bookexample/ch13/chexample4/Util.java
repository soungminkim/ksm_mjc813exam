package bookexample.ch13.chexample4;

public class Util {
    public static <P extends Pair<K, V>, K, V> V getValue(P p, K k) {
        if (p.getKey().equals(k)) {
            return p.getValue();
        } else {
            return null;
        }
    }
}
