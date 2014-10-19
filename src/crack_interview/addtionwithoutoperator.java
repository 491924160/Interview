package crack_interview;

public class addtionwithoutoperator {
	public  int add(int a, int b){
		if(b == 0)
			return a;
		int x = a ^ b;
		int carrier = (a & b) << 1;
		return add(x, carrier);
	}
	public static void main(String[]args){
		addtionwithoutoperator test = new addtionwithoutoperator();
		System.out.println(test.add(5, 6));
	}
}
