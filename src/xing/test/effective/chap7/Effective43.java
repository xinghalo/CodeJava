package xing.test.effective.chap7;

import com.sun.javafx.scene.control.skin.EmbeddedTextContextMenuContent;

import java.util.List;

/**
 * Created by Administrator on 2016/9/19.
 */
class Cheese{}

/**
 * The test is |x + y| < |x|+ |y|
 *  The test is {@literal |x+y| < |x|+|y|}
 */
public class Effective43 {
    private final List<Cheese> cheesesInStock = null;

    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

    public Cheese[] getCheeses(){
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }
}
