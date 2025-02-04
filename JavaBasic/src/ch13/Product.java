package ch13;

//다양한 제품을 표현하고자 함 (종류, 모델명)
public class Product<K, M> {
    private K kind;
    private M model;

    public K getKind(){
        return kind;
    }
    public void setKind(K kind){
        this.kind = kind;
    }
    public M getModel(){
        return model;
    }
    public void setModel(M model){
        this.model = model;
    }
}
