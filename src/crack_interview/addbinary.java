package crack_interview;

public class addbinary {
	public String addBinary(String a, String b) {
        // long  x = Integer.parseInt(a), y = Integer.parseInt(b);
        char[] a1 = a.toCharArray(), b1 = b.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        int i = a1.length - 1, j = b1.length -1; 
        while(i>=0 || j >=0){
        	int temp1 = 0, temp2 = 0;
           temp1 = i>=0?a1[i] - '0':0;
           temp2 = j>=0?b1[j] - '0':0;
            int digit = 0;
            if(flag){
                digit = (temp1+temp2+1)%2;
                if(temp1+temp2+1 >1)
                flag = true;
                else
                flag = false;
            }else{
                digit = (temp1+temp2)%2;
                if(temp1+temp2 > 1)
                flag = true;
                else flag = false;
            }
           builder.append("" + digit);
           i--;
           j--;
        }
        if(flag == true)
        	builder.append("1");
        return builder.reverse().toString();
    }
	public static void main(String[]args){
		new addbinary().addBinary("11", "1");
	}
}
