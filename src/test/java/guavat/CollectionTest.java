package guavat;

import java.util.List;

import com.google.common.collect.Lists;

public class CollectionTest {

	public static void main(String[] args) {
		List<String> list = Lists.newArrayList("lhm");
		String[] value = new String[list.size()];
		list.toArray(value);
		System.out.println(value[0]);
	}
}
