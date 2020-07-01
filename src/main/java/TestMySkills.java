import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestMySkills {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("Akshay"), new Person("Shilpa"), new Person("Ashlesha"));
		List<Integer> lsIntegers = Arrays.asList(1, 2, 3, 4);
		Person p = new Person();
		System.out.println(p.findByName("Akshays", list));

		List<Person> personReslut = list.stream().filter(person -> {
			Person plamba = new Person();
			if (person.getName().equals("Akshays")) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		System.out.println(personReslut);
		System.out.println("______________________________________________________");
		System.out.println(new Person().someFunction(lsIntegers));
		// System.out.println(new Person().someFunctionAkshay(lsIntegers));

		int[] a = { 1, 3, 2, 4, 2, 5, 3, 3, 1 };
		int s = 6;
		sum(a, s);
		Binaryjava.print(10);
		try {
			IpAdress.getIpAdress();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @param a
	 * @param sum
	 */
	public static void sum(int[] a, int sum) {

		ArrayList hashSet = new ArrayList<>();
		ArrayList hashSetOutput = new ArrayList<>();
		TreeSet treeSet = new TreeSet();
		for (int x : a) {
			treeSet.add(x);
		}

		System.out.println("::" + treeSet.size() + " " + treeSet);
		for (int i = 0; i <= treeSet.size(); i++) {
			for (int j = i; j <= treeSet.size(); j++) {

				if ((a[i] + a[j]) == sum) {
					System.out.println("elements for sum are ::" + a[i] + " && " + a[j]);
					hashSetOutput.add("(" + a[i] + "," + a[j] + ")");
				}

			}
		}

		System.out.println(hashSetOutput);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

class Person implements Comparable<Person> {
	String name;

	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	List<Person> list;

	public Person findByName(String name, List<Person> list) {
		for (Person person : list) {
			if (person.getName() == name) {
				return person;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person :[ " + name + "]";
	}

	@Override
	public int compareTo(Person o) {

		return 0;
	}

	public List<Integer> someFunction(List<Integer> input) {
		List<Integer> output = new ArrayList<Integer>();
		System.out.println("Input list::" + input);
		for (int i = 0; i < input.size(); i++) {
			int k = 1;
			for (int j = 0; j < input.size(); j++) {
				if (i != j) {// constant time f
					k = k * input.get(j);// constant time e
				}
			}
			output.add(k);
		}
		return output;
	}

	public List<Integer> someFunctionAkshay(List<Integer> input) {
		List<Integer> output = new ArrayList<Integer>();
		Supplier<List> supplier = null;
		for (int i = 0; i < input.size(); i++) {
			input.remove(i);
			supplier = someMethod(input);
		}
		return supplier.get();
	}

	public Supplier<List> someMethod(List<Integer> input) {
		return () -> {
			List list = new LinkedList();
			input.forEach((temp) -> {
				System.out.println("  ::;;" + temp);
			});
			return list;
		};
	}

}

class Binaryjava {

	public static void print(double n) {
		for (int i = 1; i <= n; i++) {
			double d = Math.pow(2, i);
			int bin = (int) Math.round(d);
			System.out.println("Binary::" + (bin - 1) + "bit rep's:::" + Integer.toBinaryString(bin - 1));
		}
	}
}

class IpAdress {
	InetAddress address;

	public static void getIpAdress() throws IOException {

		System.out.println(InetAddress.getLocalHost());
		URL url_name = new URL("http://bot.whatismyipaddress.com");
		String s = "https://www.geeksforgeeks.org";

		InetAddress ip = InetAddress.getByName(new URL(s).getHost());
		System.out.println("IP::" + ip.getHostAddress());
		String[] test = ip.getHostAddress().split("\\.");
		for (String x : test) {
			System.out.println(x);
		}
		BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
		// reads system IPAddress
		System.out.println(sc.readLine().trim());

	}
}
