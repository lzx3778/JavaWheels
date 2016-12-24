package wheels.math;

import java.util.Scanner;

public class Caculate24 {
	private static String[][] FUHAO = new String[6][3];
	public Caculate24(){
		int[] I = new int[4];
		for(int i = 0;i < I.length;i ++){
			System.out.println("Enter number "+(i+1)+":");
			while(true){
				Scanner s = new Scanner(System.in);
				int a = s.nextInt();
				if(a > 0){
					I[i] = a;
					break;
				}
			}
		}
		for(int a = 0;a < I.length;a ++){
			for(int b = 0;b < I.length;b ++){
				if(b != a){
					for(int c = 0;c < I.length;c ++){
						if((c != a)&(c != b)){
							int [][][] i3 = new int[6][][];
								for(int d = 0;d < I.length;d ++){
									if(((d != a)&(d != b))&(d != c)){
										for(int i = 0;i < 6;i ++){
											for(int j = 0;j < 6;j ++){
												for(int k = 0;k < 6;k ++){
													if(cal(I[d],cal(I[c],cal(I[b],I[a],3)[k],2)[j],1)[i]==24){
														System.out.print("("+"("+I[d]+FUHAO[k][0]+I[c]+")"+FUHAO[j][1]+I[b]+")"+FUHAO[i][2]+I[a]+"="+"24\n");
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	public static int[] cal(int i,int j,int time){
		time -= 1;
		int[] base = new int[6];
		int[] t = {i+j,i-j,j-i,i*j};
		String[] ST = {"+","-","-","*","/","/"};
		for(int I = 0;I < 4;I++){
			base[I] = check(i,j,t[I]);
			FUHAO[I][time] = ST[I];
		}
		if(j != 0){
			base[4] = check(i,j,i / j);
			FUHAO[4][time] = ST[4];
		}else{
			base[4] = -1;
		}
		if(i != 0){
			base[5] = check(i,j,j / i);
			FUHAO[5][time] = ST[5];
		}else{
			base[5] = -1;
		}
		return base;
	}
	public static int check(int i,int j,int an){
		if(i == -1 | j == -1){
			return -1;
		}
		return an;
	}
}