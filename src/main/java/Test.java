import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		//
		String absolutePath = "D:\\G Drive\\projects\\springprojects\\Ashlesha_File_Sorter\\Ashlesha File Sorter\\test file.txt";
		StringTokenizer st = new StringTokenizer(absolutePath, "\\");

		int tokenLen = st.countTokens() - 1;
		System.out.println(tokenLen + " " + st.countTokens());
		StringBuffer stringBuffer = new StringBuffer();
		while (tokenLen > 0) {
			System.out.println(tokenLen + " " + st.countTokens());

			stringBuffer.append(st.nextToken());
			stringBuffer.append(File.separator);
			tokenLen--;
		}
		System.out.println(stringBuffer.toString());

		StringBuffer sb = new StringBuffer("Akshay Singh Akshay Singh");
		StringBuffer sbt = new StringBuffer("Singh");
		System.out.println("::::" + sb.indexOf(sbt.toString()));
		String str = "vvjbjahjbhelloslkhellodjladfjhellohjkl;";
		String findStr = "hello";
		int lastIndex = 0;
		int count = 0;

		while (lastIndex != -1) {

			lastIndex = str.indexOf(findStr, lastIndex);

			if (lastIndex != -1) {
				count++;
				lastIndex += findStr.length();
			}
		}
		System.out.println("::::occurence::" + count);
		System.out.println("Enter String to check palindrom:::");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		System.out.println("Palindrome test:::::" + Palindrome.isPalindrome(word));

	}

}

class Palindrome {
	public static boolean isPalindrome(String word) {
		StringBuffer target = new StringBuffer(word);
		if (target.reverse().toString().equalsIgnoreCase(word)) {
			return true;
		} else

			throw new UnsupportedOperationException("Waiting to be implemented.");
	}

}

class Parent {
	int x=10;
	protected  void show() throws IOException{
		System.out.println("Parent's show()"+"::var::"+x);
	}
	
	private void parentShoe() {
		System.out.println("private of parent");
		
	}
	static void test()
	{
			System.out.println("static method of parent");
	}
}

// Inherited class
class Child extends Parent {

	int x=20;
	public void parentShoe() {
		System.out.println("private of parent");
		
	}
	@Override
	public void show() throws RuntimeException {
		// TODO Auto-generated method stub
		try {
			super.show();
			System.out.println("\"Childs's show()\"+\"::var::\"+x"+x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void test()
	{
			System.out.println("static method of parent");
	}
	// This method overrides show() of Parent
	
	
}
abstract class  MyAbstract{
	
	 protected abstract void run() throws Exception;  
	
}
class MyAbstarcImpl extends MyAbstract{

	@Override
	public void run() throws RuntimeException,InterruptedException {
		System.out.println("");
	}
	
}

// Driver class
class Main {
	public static void main(String[] args) throws IOException  {
		Parent obj = new Child();
		
		Child objChild = new Child();
		obj.show();
		
		objChild.parentShoe();
		System.out.println("parent ref to chile object::"+obj.x);
		//obj.parentShoe(); compile time error as parent ref will look for parent private method it will "method is not visibile"
		obj.test();
		objChild.test();
		System.out.println("Root path::"+System.getProperty("user.dir"));
	}
}