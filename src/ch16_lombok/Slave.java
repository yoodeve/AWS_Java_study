package ch16_lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// allargu생성자 생성
@AllArgsConstructor
// toString오버라이드
@ToString
// noArgu생성자도 생성
@NoArgsConstructor
// setter
@Setter
// getter
//@Getter
@EqualsAndHashCode
// 전부다해도라
@Data
public class Slave {
	private String name;
	// 이렇게 하면 name getter는 작성 안됨
	@Getter
	private int age;
}
