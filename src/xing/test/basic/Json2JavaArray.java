package xing.test.basic;

import com.alibaba.fastjson.JSON;

class Students{
	private String[] ids;
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
}
public class Json2JavaArray {
	public static void main(String[] args) {
		String params = "{\"ids\":[\"no201601\",\"no201602\",\"no201603\"]}";
		Students stds = JSON.parseObject(params,Students.class);
		System.out.println(stds.toString());
	}
}
