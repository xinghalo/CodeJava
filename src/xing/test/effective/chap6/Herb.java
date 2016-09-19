package xing.test.effective.chap6;

/**
 * Created by Administrator on 2016/9/19.
 */
class Herb{
    public enum Type {
        ANNUAL,PERENNIAL,BIENNTAL
    }
    private final String name;
    private final Type type;

    Herb(String name,Type type){
        this.name = name;
        this.type = type;
    }
    public Type getType(){
        return type;
    }
    @Override
    public String toString(){
        return name;
    }
}