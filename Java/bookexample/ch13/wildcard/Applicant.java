package bookexample.ch13.wildcard;

public class Applicant<T>{
    public T kind;

    public Applicant(T kind) {
        this.kind = kind;
    }
}
