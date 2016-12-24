package wheels.math;

public class Sort1 {
	public static int[] intSort(int[] L1){
		int c = 0;
		int count = 0;
		int swap = 0;
		while(count < 2){
			swap = 0;
			for(int i = 0;i < L1.length-1;i++){
				if (L1[i] > L1[i+1]){
					c = L1[i];
					L1[i] = L1[i+1];
					L1[i+1] = c;
					swap ++;
				}
			}
			if(swap == 0){
				break;
			}
			count++;
		}
		return L1;
	}
}