package crack_interview;

public class checkprime {
	public boolean isPrime(int val){
		for(int i = 2; i <= val/2; i++){
			if(val % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[]args){
		int[] array = new int[100];
		for(int i = 0; i < array.length; i++){
			array[i] = i;
		}
		for(int temp: array){
			System.out.println(temp + "is prime" + new checkprime().isPrime(temp));
		}
	}
}
