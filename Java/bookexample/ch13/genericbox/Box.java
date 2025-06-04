package bookexample.ch13.genericbox;

public class Box<T> {
    public T content;

    public boolean compare(Box<T> other) {
        // boolean result = content.equals(other.content);
        // return result;
        // 해방 방법도 있지만 해당 방법 보다 아래 방법도 있겠다 싶다.
        return content.equals(other.content);
    }
}
