package xing.test.thinking.chap02;
/**
 * {@inheritDoc}
 * 
 * @author xxh
 *
 */
class ClassC extends ClassB{
	
}
/**
 * 测试link  {@link xing.test.thinking.chap02.ClassA#test() ClassA}<br>
 * 文档路径：{@docRoot}<br>
 * 
 * 
 * @since ClassA
 * 
 * @see ClassA
 * @see ClassA#test()
 * @see ClassA#i
 * 
 * @version v1.0
 * @author xxh 我的主机名
 */
class ClassB extends ClassA{
	
}
/**
 * JavaDoc类注释
 * 
 * @author xxh
 */
class ClassA{
	/*
	 * 多行注释
	 */
	//单行注释
	/**
	 * JavaDoc 字段注释
	 */
	int i;
	/**
	 * JavaDoc 方法注释
	 * 
	 * @param ttt 参数注释
	 * @return Str 返回值
	 * @throws Exception 异常
	 */
	@Deprecated
	public String test(String ttt) throws Exception{
		return null;
	}
}
public class JavaDocTest {
	
}
