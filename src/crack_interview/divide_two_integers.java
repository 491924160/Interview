package crack_interview;

public class divide_two_integers {
	 public int divide(int dividend, int divisor) {
	        int len = 0;
	        boolean flag1 = dividend>=0? true : false;
	        boolean flag2 = divisor>=0 ?true: false;
	        boolean final_flag = flag1 ^ flag2;
	        dividend = dividend>=0 ? dividend: -dividend;
	        long long_divisor = divisor;
	        long_divisor = long_divisor>=0? long_divisor: -long_divisor;
	        while(long_divisor != 0){
	        	len++;
	        	long_divisor = long_divisor >> 1;
	        }
	        while(len-- > 0)
	        	dividend = dividend >>1;
	        if(final_flag)
	        	return -dividend;
	        else return dividend;   
	    }
	 public int divide_1(int dividend, int divisor){
		 	boolean flag1 = dividend>=0? true : false;
	        boolean flag2 = divisor>=0 ?true: false;
	        boolean final_flag = flag1 ^ flag2;
	        long dis = divisor;
	        long did = dividend;
	        dis = dis>=0?dis:-dis;
	        did = did>=0?did:-did;
	        long abs_dis = dis;
	        int len = 0;
	        if(did < dis)
	        	return 0;
	        while(dis < did){
	        	len++;
	        	dis = dis<<1;
	        }
	        int result = 0;
	        while(dis >= abs_dis){
	        	if(did >= dis){
	        		result+=1<<len;
	        		did = did - dis;
	        	}
	        	dis >>=1;
	        	len--;
	        }
	        return final_flag?-result:result;
	 }
	 public static void main(String[]args){
		 System.out.println(new divide_two_integers().divide(-1010369383, -2147483648
));
	 }
}
