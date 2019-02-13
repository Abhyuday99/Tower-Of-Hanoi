package binarySearch;

public class GeneralizedTowerOfHanoi {
		
public static void gtoh_with_recursion(int num_disks,int start_pos,int[] final_positions) {
		
		if(num_disks == 1) {
			if(start_pos != final_positions[0]) {
				System.out.println(start_pos + " " + final_positions[0]);
		}
			return ;
		}
		int index = num_disks -1 ;
		while(final_positions[index] == start_pos && index > 0) {
			index-- ;
		}
		if(index == 0) {
			int[] arr = {final_positions[index]} ;
			gtoh_with_recursion(1,start_pos,arr) ;
			return ;
		}
		int[] positions = new int[index] ;
		int pos = 6 - start_pos - final_positions[index] ;
		for(int i = 0 ; i < index ; i++) {
			positions[i] = pos ;
		}
		gtoh_with_recursion(index,start_pos,positions) ;
		int[] arr = {final_positions[index]} ;
		gtoh_with_recursion(1,start_pos,arr) ;
		System.arraycopy(final_positions,0,positions,0,index) ; 
		gtoh_with_recursion(index,pos,positions) ;
		return ;
		
	}
	
	public static void gtoh_without_recursion(int num_disks,int start_pos,int r , int b) {
		MyStack<Pair> stack = new MyStack<Pair>() ;
		while(true) {
			if(num_disks == 0) {
				break ;
			}
			if(num_disks % 2 == 0 && start_pos == r) {
				num_disks-- ;
			}
			else if (num_disks % 2 == 1 && start_pos == b) {
				num_disks-- ;
			}
			else {
				break ;
			}
		}
		if(num_disks == 0) {
			return ;
		}
		
		int end_pos ;
		if(num_disks % 2 == 0) {
			end_pos = r ;
		}
		else {
			end_pos = b ;
		}
		stack.push(new Pair(-1,start_pos,end_pos));
		int flag = num_disks ;
		Pair temp ;
		
		while(!stack.empty()) {
			
			if(flag <= 0) {
				temp = stack.pop();
				if(temp.num_disks == -1) {
					break ;
				}
				if(temp.num_disks == num_disks) {
					num_disks-- ;
				}
				System.out.println(temp.start + " " + temp.end);
				flag = temp.num_disks - 1 ;
				end_pos = temp.end ;
				start_pos = 6 - temp.start - temp.end ;
				
			}
			else {
				if(flag  == num_disks) {
					System.out.println("Flag = " + flag);
					while(true) {
						if(flag == 0) {
							break ;
						}
						if(flag % 2 == 0 && start_pos == r) {
							flag-- ;
							num_disks-- ;
						}
						else if (flag % 2 == 1 && start_pos == b) {
							flag-- ;
							num_disks-- ;
						}
						else {
							break ;
						}
					}
					if(flag == 0) {
						break ;
					}
					if(num_disks % 2 == 0) {
						end_pos = r ;
					}
					else {
						end_pos = b ;
					}
				}
				stack.push(new Pair(flag,start_pos,end_pos)) ;
				end_pos = 6 - start_pos - end_pos ;
				flag-- ;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6 ;
		int[] arr = new int[n] ;
		for(int i = 0 ; i < n ; i++ ) {
			if(i % 2 == 0) {
				arr[i] = 3 ;
			}
			else {
				arr[i] = 2 ;
			}
		}
		gtoh_with_recursion(4,1,arr) ;
		System.out.println("\n");
		gtoh_without_recursion(4,1,2,3) ;
		System.out.println("SUCCESS");
	}

}
