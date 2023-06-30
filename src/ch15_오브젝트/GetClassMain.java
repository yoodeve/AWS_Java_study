package ch15_오브젝트;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetClassMain {
	public static void main(String[] args) {
		KoreaStudent koreaStudent = new KoreaStudent("2023333", "한유정");
		Method[] methods = koreaStudent.getClass().getDeclaredMethods();

		// getName, equals, toString, hashCode, getStudentCode, showInfo
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
			System.out.println(methods[i].getReturnType());
			System.out.println();
		}

		System.out.println();
		Field[] fields = koreaStudent.getClass().getDeclaredFields();
		// studentCode, name
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
		System.out.println();
		System.out.println("======================");
		System.out.println();
		System.out.println("클래스 타입 비교: " + (KoreaStudent.class == koreaStudent.getClass()));
		// 불가 :
		// System.out.println("클래스 타입 비교: " + (Object.class ==
		// koreaStudent.getClass()));
		// 상속관계는 비교불기
		System.out.println(koreaStudent instanceof Object);
		// 클래스명만
		System.out.println(koreaStudent.getClass().getSimpleName());
		// 클래스명에 패키지경로까지
		System.out.println(koreaStudent.getClass().getName());
	}

}
