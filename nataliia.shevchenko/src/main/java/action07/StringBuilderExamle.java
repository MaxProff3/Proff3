package action07;

public class StringBuilderExamle {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("line 1");
		sb.append("line 2");
		String sub = sb.toString();
		System.out.println(sub);
		System.out.println("**************************");

		String s1 = "ab";
		String s2 = "ab";
		if(s1 == s2) System.out.println("==");
		else System.out.println("!=");
		System.out.println("**************************");
		
		String s3 = new String("ab");
		if(s1 == s3) System.out.println("==");
		else System.out.println("!=");
		
		
	
	
	}

}
