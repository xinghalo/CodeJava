package xing.test.effective.chap6;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EnumMapDemo {
    public static void main(String[] args) {
        Set<Herb> gardern = new HashSet<Herb>();
        gardern.add(new Herb("herb1",Herb.Type.ANNUAL));
        gardern.add(new Herb("herb2",Herb.Type.PERENNIAL));
        gardern.add(new Herb("herb3",Herb.Type.ANNUAL));
        gardern.add(new Herb("herb4",Herb.Type.BIENNTAL));
        gardern.add(new Herb("herb5",Herb.Type.BIENNTAL));
        gardern.add(new Herb("herb6",Herb.Type.ANNUAL));
        Map<Herb.Type, Set<Herb>> map = test1(gardern);
        System.out.println(map);
        Map<Herb.Type, Set<Herb>> map1 = test2(gardern);
        System.out.println(map1);
    }
    public static Map<Herb.Type, Set<Herb>> test1(Set<Herb> gardern){
        Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
        for(Herb.Type t : Herb.Type.values()){
            herbsByType.put(t, new HashSet<Herb>());
        }
        for(Herb h : gardern){
            herbsByType.get(h.getType()).add(h);
        }
        return herbsByType;
    }
    public static Map<Herb.Type, Set<Herb>> test2(Set<Herb> gardern){
        Map<Herb.Type, Set<Herb>> herbsByType = new HashMap<Herb.Type, Set<Herb>>();
        for(Herb.Type t : Herb.Type.values()){
            herbsByType.put(t, new HashSet<Herb>());
        }
        for(Herb h : gardern){
            herbsByType.get(h.getType()).add(h);
        }
        return herbsByType;
    }
}
