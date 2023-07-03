package ch19_제네릭;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
// 꺽쇠 : 제네릭
public class Response<T> {

	// 형태가 고정이 아닌것 -> 제네릭(타입을 유동적으로 적용하기 위해)
	private int statusCode;
	// 상황에 따라 다른 데이터 반환해야돼서 String만 뱉도록 고정할 수 없다.
	// 제네릭:자료형에 대한 변수
	private T data;

}
