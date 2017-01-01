package dataStruct;

import java.util.*;

import wheels.no_Graphic.Enter;

public class javaStack {
	public javaStack() {
		int[] a = new int[5];
		int IN = 0;
		for (int i = 0; i < a.length; i++) {
			inside: System.out.println("Enter a number:");
			IN = Enter.E_int();
			a[a.length - i - 1] = IN;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}