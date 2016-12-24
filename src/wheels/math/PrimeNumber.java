package wheels.math;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrimeNumber {
	public static void main(String[] args)throws IOException{
		FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\lenovo\\Desktop\\prime.txt"));
		PrintStream p = new PrintStream(fs);
		final int num = 1000000;
		final int line = 10;
		int count = 0;
		int number = 100000;
		while(count < num){
			boolean isPrime = true;
			for (int i = 2;i <= number / 2;i++){
				if(number % i == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				count ++;
				if(count % line == 0){
					p.println(number);
				}else{
					p.print(number + " ");
				}
			}
			number++;
		}
		p.close();
	}
}
