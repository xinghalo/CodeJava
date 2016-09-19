package xing.test.effective.chap6;

import java.util.EnumMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/19.
 */

public class Effectuve33 {
    public static void main(String[] args) {
//        Set<Herb>[] herbsByType = (Set<Herb[]>) new Set[Herb.Type.values().length];
            Map<Herb.Type,Set<Herb>> herbsByType = new EnumMap<Herb.Type,Set<Herb>>(Herb.Type.class);
            for(Herb.Type t : Herb.Type.values()){
                herbsByType.put(t,new HashSet<Herb>());
            }
        System.out.println(herbsByType);
    }
}
