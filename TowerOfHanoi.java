package binarySearch;

class Pair {
	
	public int num_disks ;
	public int start ;
	public int end ;
	
	Pair(int x, int y,int z){
		this.num_disks = x ;
		this.start = y ;
		this.end = z ;
	}
}
public class TowerOfHanoi {
	
	public static void toh_with_recursion(int num_disks,int start_pos,int end_pos) {
		
		if(num_disks == 1) {
			System.out.println(start_pos +  " " + end_pos);
			return ;
		}
		int pos = 6 - start_pos - end_pos ;
		toh_with_recursion(num_disks-1,start_pos,pos) ;
		toh_with_recursion(1, start_pos, end_pos);
		toh_with_recursion(num_disks-1,pos,end_pos) ;
		return ;
		
	}
	
public static void toh_without_recursion(int num_disks,int start_pos,int end_pos) {
		
		MyStack<Pair> stack = new MyStack<Pair>() ;
		int pos  = end_pos ;
		stack.push(new Pair(-1,start_pos,end_pos));
		int flag = num_disks ;
		Pair temp ;
		while(!stack.empty()) {
			
			if(flag == 0) {
				temp = stack.pop();
				if(temp.num_disks == -1) {
					break ;
				}
				System.out.println(temp.start + " " + temp.end);
				flag = temp.num_disks - 1 ;
				end_pos = temp.end ;
				start_pos = 6 - temp.start - temp.end ;
			}
			else {
				stack.push(new Pair(flag,start_pos,end_pos)) ;
				end_pos = 6 - start_pos - end_pos ;
				flag-- ;
			}
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toh_with_recursion(4,1,3) ;
		System.out.println("\n\n");
		toh_without_recursion(4,1,3) ;

	}

}
