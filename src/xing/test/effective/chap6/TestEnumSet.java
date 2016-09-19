package xing.test.effective.chap6;

import java.util.EnumSet;

/**
 * Created by Administrator on 2016/9/19.
 */
public class TestEnumSet {
    public enum ColorFeature {
        RED,BLUE, GREEN, YELLOW,BLACK
    } ;
    public static void main(String[] args) {
        EnumSet allFeatures = EnumSet.allOf(ColorFeature.class);
        EnumSet warmColorFeatures = EnumSet.of(ColorFeature.RED,ColorFeature.YELLOW);
        EnumSet non_warmColorFeatures = EnumSet.complementOf(warmColorFeatures);
        EnumSet notBlack = EnumSet.range(ColorFeature.RED, ColorFeature.YELLOW);

        for (ColorFeature cf : ColorFeature.values()){
            if (warmColorFeatures.contains(cf)) {
                System.out.println("warmColor "+cf.name());
            }
            if (non_warmColorFeatures.contains(cf)) {
                System.out.println("non_WarmColor "+cf.name());
            }
        }
    }
}