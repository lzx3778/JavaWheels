package tryPack;

import wheels.no_Graphic.PrintArray;

public class BooleanArray {
	public BooleanArray(){
		int[] a = new int[4];
		boolean[] b = new boolean[4];
		a[0] = -10;
		
		for(int i = 0;i < a.length;i++){
			
			if (b[i]) {
				a[i] -= 10;
			}else {
				a[i] += 10;
			}
			
		}
		
		for(int i = 0;i < a.length;i++){
			System.out.println(i);
			if (a[i] >= 10) {
				b[i] = true;
			}else if(a[i] <= 0){
				b[i] = false;
			}

			System.out.println(b[i]);
		}


	}
}
