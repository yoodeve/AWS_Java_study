package ch20_컬렉션;

import java.util.ArrayList;
import java.util.LinkedList;

public class StringArrayListMain {
	public static void main(String[] args) {
		CustomArrayList list = new CustomArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add(1, "f");

		list.remove();
		System.out.println("1" + list);
		System.out.println("3" + list.remove(2));
		System.out.println("1" + list);
//		list.set(3, "t");
		System.out.println(list);

		System.out.println("++++++++++++++++++++++++++++");
		ArrayList<String> arrayList = new ArrayList<>();

		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		arrayList.add("e");
		arrayList.add("f");
		arrayList.add(1, "u");
		arrayList.remove(2);
		arrayList.set(0, "x");

		// 자주사용하는 메소드
		arrayList.add(null);
		arrayList.contains(arrayList);
		arrayList.forEach(null);
		arrayList.get(0);
		arrayList.set(0, null);

		System.out.println(arrayList);

		// 앞에 제네릭 명시하면 뒤는 동일 제네릭 생략 가능
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.addFirst("0");
	}
}
