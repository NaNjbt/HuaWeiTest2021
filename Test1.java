/*
 *思想：自底向上遍历，因为主机名肯定是唯一的 （只考虑了树状结构）
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<String> re = new ArrayList<>();
		ArrayList<String> in1 = new ArrayList<>(n);
		ArrayList<String> in2 = new ArrayList<>(n);
		int i,j;
		for(i = 0; i < n; i++){
			in1.add(in.next());
			in2.add(in.next());
		}
		String top = in.next();
		for(i = 0; i < n; i++){
			String t1 = in1.get(i);
			if(in2.contains(t1)) continue;
			String t2 = in2.get(i);
			String t = t1 + "." + t2;
			
			while(!t2.equals(top)){
				for(j = 0; j < n; j++){
					if(in1.get(j).equals(t2)){
						t2 = in2.get(j);
						t = t + "." + t2;
						break;
					}
				}
			}
			re.add(t);
			
		}
		//字符串排序 compareTo接口
		for(i = 0; i < re.size()-1; i++){
			for(j = i+1; j<re.size();j++){
				if(re.get(i).compareTo(re.get(j)) > 0){
					String temp = re.get(i);
					re.set(i, re.get(j));
					re.set(j, temp);
				}
			}
		}
		
		for(String s: re){
			System.out.println(s);
		}
	}

}
