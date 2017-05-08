/**
	The purpose of this exericise is, given the code snippets at the bottom of this file, 
	rearrange them to get the desired output which is:

	% java ExTestDrive yes
	thaws

	% jave ExTestDrive no
	throws
	
	This exercise is to practice what is learned about exception handling in Java.
	From Head First Java, Second Edition by Kathy Sierra and Bert Bates
*/

class MyEx extends Exception { 


}

public class ExTestDrive {


	public static void main(String[] args) {

		String test = args[0];

		try {

			System.out.print("t");

			doRisky(test);

			System.out.print("r");
			System.out.print("o");


		}
		catch (MyEx e) {
				
			System.out.print("a");
				

		}
		finally {
			System.out.print("w");	
			System.out.println("s");

		}

	}

	static void doRisky(String t) throws MyEx {

		System.out.print("h");

		if ("yes".equals(t)) {
			throw new MyEx();
		}

	}


}

/*

Find below all code snippets.

System.out.print("r");

try{

}

doRisky(test);

System.out.print("t");

System.out.println("s");

finally {

}

System.out.print("o");

class MyEx extends Exception { }

public class ExTestDrive {

}

System.out.print("w");

if ("yes".equals(t)) {

}

System.out.print("a");

throw new MyEx();

catch (MyEx e) {

}

static void doRisky(String t) throws MyEx {

	System.out.print("h");

}

public static void main(String[] args) {

	String test = args[0];
}

*/