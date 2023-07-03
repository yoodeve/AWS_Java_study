package ch20_컬렉션;

public class CustomArrayList {

	private String[] array;

	public CustomArrayList() {
		array = new String[0];
	}

	public void add(String str) {
		String[] newArray = new String[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[newArray.length - 1] = str;
		array = newArray;
	}

//	public String remove(int idx) {
//		return null;
//	}

	public void add(int idx, String str) {

		String[] newArray = new String[array.length + 1];

		for (int i = 0; i < idx; i++) {
			newArray[i] = array[i];
		}
		newArray[idx] = str;
		for (int i = idx; i < array.length; i++) {
			newArray[i + 1] = array[i];
		}
		array = newArray;
	}

	public String remove() {
		// 마지막꺼 삭제, 삭제값 리턴
		String[] newArray = new String[array.length - 1];
		for (int i = 0; i < array.length - 1; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
		return array[array.length - 1];
	}

	public String remove(int index) {
		// 마지막꺼 삭제, 삭제값 리턴
		String[] newArray = new String[array.length - 1];
		String value = array[index];
		for (int i = 0; i < array.length; i++) {
			int tempIndex = i - 1;
			if (i == index) {
				continue;
			}
			if (i < index) {
				tempIndex = i;
			}
			newArray[tempIndex] = array[i];
		}
		array = newArray;
		return value;
	}

	public void set(int index, String str) {
		array[index] = str;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		// 향상된 for문, forEach, 배열의 처음부터 끝까지 순회하여 블럭 내 코드 실행됨.
		// 포문의 인덱스가 크게 중요치 않은 경우 사용
		for (String str : array) {
			builder.append(str + ",");
		}
		builder.delete(builder.lastIndexOf(","), builder.length());
		builder.append("]");
		return builder.toString();
	}

}
