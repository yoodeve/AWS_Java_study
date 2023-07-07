package test;

import java.util.List;

public class subjectService {
	private List<String> subjects;

	public subjectService(List<String> subjects) {
		this.subjects = subjects;
	}

	public void showSubjects() {
		int length = 3;
		for (int i = 0; i < length; i++) {
			System.out.println(subjects.get(i));
		}
	}
}