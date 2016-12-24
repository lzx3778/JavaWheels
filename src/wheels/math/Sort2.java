package wheels.math;

public class Sort2 {
	public static int[] intSort2(int[] a){
		int place = 0;
		int swap = 0;
		for(int i = 0;i < a.length;i ++){
			swap = 0;
			int small = 1000;
			for(int j = i;j < a.length;j ++){
				if(a[j] < small){
					small = a[j];
					place = j;
					swap ++;
				}
			}
			if(swap == 0){
				break;
			}
			a[place] = a[i];
			a[i] = small;
		}
		return a;
	}
}
