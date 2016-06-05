package action07;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("line 1");
		sb.append(", line 1.1\n");
		sb.append("line 2\nline 3\n");
		String s = sb.toString();
		System.out.println(sb);
		 
		String s1 = "ab";
		String s2 = "ab";
		if(s1==s2) System.out.println("==");
		else System.out.println("!=");
		String s3 = new String("ab");
		if(s1==s3) System.out.println("==");
		else System.out.println("!=");
	}
}
