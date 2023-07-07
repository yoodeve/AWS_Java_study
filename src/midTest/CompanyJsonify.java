package test;

import com.google.gson.Gson;

public class CompanyJsonify {
	public static void main(String[] args) {
		Company company = new Company(100, "Apple", "Apple Computer Inc. 1 infinite loop", "Cupertino", "CA", "95014");
		Gson gson = new Gson();
		String jsonifiedUser = gson.toJson(company);
		System.out.println(jsonifiedUser);
	}
}
