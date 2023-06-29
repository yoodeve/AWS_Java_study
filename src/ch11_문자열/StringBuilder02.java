package ch11_문자열;

public class StringBuilder02 {
	public static void main(String[] args) {
		String[] roles = { "ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN" };

		String strRoles = "";
		for (int i = 0; i < roles.length; i++) {
			strRoles += roles[i] + ", ";
			if (i == roles.length - 1) {
				strRoles += roles[i];
				break;
			}
		}

		StringBuilder strRolesBuilder = new StringBuilder();

		for (int i = 0; i < roles.length; i++) {
			strRolesBuilder.append(roles[i] + ", ");
		}
		strRolesBuilder.delete(strRolesBuilder.lastIndexOf(", "), strRolesBuilder.length() - 1);
		System.out.println(strRolesBuilder.toString());
	}
}
