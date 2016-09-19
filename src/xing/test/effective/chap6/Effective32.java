package xing.test.effective.chap6;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/19.
 */

public class Effective32 {
    public enum Style {
        BOLD,ITALIC,UNDERLINE,STRIKETHROUGH;
    }
    public void applyStyles(Set<Style> styles){

    }

    public static void main(String[] args) {
        Effective32 ef = new Effective32();
        ef.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
