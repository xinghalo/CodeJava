package xing.test.thinking.chap15;
/**
 * 使用这个构造器需要两个特点：
 * 1 必须声明为public
 * 2 必须具备默认的无参构造函数
 * 
 * @author xxh
 *
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;
	public BasicGenerator(Class<T> type) {
		this.type = type;
	}
	@Override
	public T next() {
		try{
			return type.newInstance();
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<>(type);
	}
}
