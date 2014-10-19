package crack_interview;

import java.util.*;

public class PalindromePartitioning {
	public boolean check(String s, int start, int end){
		if(start == end)
			return true;
		if(start > end)
			return false;
		while(start < end){
			if(s.charAt(start++) == s.charAt(end--)){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}
	public void createlist(Map<Integer, ArrayList<Integer>> map, String s, List<List<String>> list, String source, int start){
		for(int i = start; i < s.length(); i++){
			ArrayList<Integer> temp_list = map.get(start);
			Iterator<Integer> iter = temp_list.iterator();
			String temp_string = null;
			while(iter.hasNext()){
				int end = iter.next();
				temp_string = s.substring(start, end);
				if(start != 0){
					temp_string = source + " " + temp_string;
				}
				if(end < s.length()){
					createlist(map, s, list, temp_string, end);
				}else{
					ArrayList<String> result = new ArrayList<String>();
					String[] array = temp_string.split(" ");
					for(String str : array){
						result.add(str);
					}
					list.add(result);
				}
			}
		}
	}
	public List<List<String>> partition(String s){
		List<List<String>> list = new ArrayList<List<String>>();
		if(s == null)
			return null;
		if(s.length() <= 1){
			List<String> temp_list = new ArrayList<String>();
			temp_list.add(s);
			list.add(temp_list);
			return list;
		}
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < s.length(); i++)
			map.put(i, new ArrayList<Integer>());
		for(int i = s.length(); i >= 0; i--){
			if(i < s.length() && map.get(i).isEmpty())
				continue;
			for(int j = i - 1; j>=0; j-- ){
				if(check(s, j, i -1)){
					ArrayList<Integer> temp_list = map.get(j);
					temp_list.add(i);
				}
			}
		}
		createlist(map, s, list, "", 0);
		return list; 
	}
	
	public List<List<String>> partition2(String s){
		if(s == null)
			return null;
		int len = s.length();
		List<List<String>>[] result = new List[len + 1];
		boolean[][] pair = new boolean[len][len];
		result[0] = new ArrayList<List<String>>();
		result[0].add(new ArrayList<String>());
		for(int i = 0; i < s.length(); i++){
			result[i + 1] = new ArrayList<List<String>>();
			for(int j = i; j >= 0; j--){
				if(j == i){
					pair[j][i] = true;
				}else{
					char prev = s.charAt(j), next = s.charAt(i);
					if(prev != next)
						pair[j][i] = false;
					if(j == i-1)
						pair[j][i] = true;
					else
						pair[j][i] = pair[j + 1][i - 1];
				}
				if(pair[j][i]){
					String temp = s.substring(j, i+1);
					Iterator<List<String>> iter = result[j].iterator();
					while(iter.hasNext()){
						List<String> list_temp = iter.next();
						list_temp.add(temp);
						result[i + 1].add(list_temp);
					}
				}
				
			}
		}
	return result[len];
		
	}
}
