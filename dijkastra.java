package ds;
import java.util.Scanner;
public class dijkastra {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		//sSystem.out.print("Dijkastra");
		int v=sc.nextInt();
		int e=sc.nextInt();
		int[][] mat=new int[v][v];
		for(int i=0;i<e;i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int weight=sc.nextInt();
			mat[v1-1][v2-1]=weight;
			mat[v2-1][v1-1]=weight;
		}
		dij(mat);
	}
	
	 static void dij(int[][] mat) {
		int v=mat.length;
		int[] distance=new int[v];
		boolean[] visit=new boolean[v];
		distance[0]=0;
		for(int i=1;i<v;i++) { 
			distance[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<v-1;i++) {
			int minver=findMin(distance, visit);           //Find min vertex
			visit[minver]=true;
			//Explore neighbour
			for(int j=0;j<v;j++) {
				if(mat[minver][j]!=0 && !visit[j]) {
					int dist=distance[minver]+mat[minver][j];
					if(dist<distance[j]) {
						distance[j]=dist;
					}
				}
			}	
		}
		for(int i=0;i<v;i++) {
			if(distance[i]==Integer.MAX_VALUE)
			{
				System.out.println(i+" "+"No specified Path");
			}
			else
			{
				System.out.println(i+" "+distance[i]);
			}
		}
	}
	 
	 
	 static int findMin(int[] distance, boolean[] visit) {
		int min=-1;
		for(int i=0;i<distance.length;i++) {
			if(!visit[i] && (min==-1||distance[i]<distance[min])) {
				min=i;
			}
		}
		 return min;
	 }

}
