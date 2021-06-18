import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String[] name = new String[n];
		int[] cost = new int[n];
		int[][] next = new int[n][n];
		int[] indegree = new int[n];
		int[] timeSum = new int[n];
		Queue<Integer> qu = new LinkedList<>();
		int i, j;
		for(i = 0; i < n; i++){
			String t1 = in.nextLine();
			String[] t = t1.split(" ");
			name[i] = t[0];
			cost[i] = Integer.parseInt(t[1]);
			for(j = 0; j < n; j++){
				next[i][j] = -1;
				if(j < t.length-2){
					next[i][j] = Integer.parseInt(t[j+2]);
					indegree[next[i][j]] ++;
				}

			}
		}
		
		for(i = 0; i < n; i++){
			if(indegree[i] == 0){
				qu.add(i);
				indegree[i]--;
				timeSum[i] = cost[i];
			}
				
		}
		
		while(true){
			while(!qu.isEmpty()){
				int t = qu.poll();
				i = 0;
				while(next[t][i]!=-1){
					indegree[next[t][i]]--;
					timeSum[next[t][i]] = Math.max(timeSum[next[t][i]], timeSum[t]+cost[next[t][i]]);
					i++;
				}	
			}
			for(i = 0; i < n; i++){
				if(indegree[i] == 0){
					qu.add(i);
					indegree[i]--;
				}
			}
			if(qu.isEmpty()) break;
			
		}
		int max = timeSum[0];
		for(i = 1; i < n; i++){
			if(max < timeSum[i])
				max = timeSum[i];
		}
		System.out.println(max);
		
	}

}