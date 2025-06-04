package bookexample.ch13.generictype;

public class Product <K, M>{
    private K kind;
    private M model;

    public K getKind() { return this.kind; } // 리턴 K 형태로
    public void setKind(K kind) { this.kind = kind; }

    public M getModel() { return this.model; } // 리턴 M형태로
    public void setModel(M model) { this.model = model; }
}
