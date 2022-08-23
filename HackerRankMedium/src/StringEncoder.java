
public class StringEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decode("еб"));

	}
	
	public static String decode(String text) {
		StringBuilder d=new StringBuilder(text);
		StringBuilder ans=new StringBuilder();
		d.reverse();
		for(int i=0;i<d.length();i++) {
			char c=d.charAt(i);
			c=(char) ((c-i)/2);
			ans.append(c);
		}
		return ans.toString();
	}

}
