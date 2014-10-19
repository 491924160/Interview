package crack_interview;

public class removeduplicate {
	 static char[] remove_duplicate(char[] str){
		if(str == null)
			return str;
		int length = str.length;
		if(length < 2)
			return str;
		int tail = 1;
		for(int i = 1; i < length; i++){
			int j = 0;
			for(j = 0; j < tail; j++){
				if(str[j] == str[i]) break;
			}
			if(j == tail){
				str[tail] = str[i];
				tail++;
			}
				
		}
		str[tail] = '\0';
		return str;
	}
}
