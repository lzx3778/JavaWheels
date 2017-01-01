package singlePrograms;

import java.util.*;

public class cross {
	public cross() {
		int[] base = new int[9];
		String[] symbols = new String[3];

		for (int i = 0; i < base.length; i++) {
			base[i] = 0;
		}
		symbols[0] = "   ";
		symbols[1] = " O ";
		symbols[2] = " X ";

		System.out.println("places:");

		for (int i = 0; i < 9; i++) {
			draw(base, symbols);

			int enter = 0;
			while (true) {
				enter = input(base);
				if (enter == -2) {
					System.out.println("You didn't enter a number");
					continue;
				} else if (enter == -1) {
					System.out.println("This place isn't empty");
					continue;
				} else {
					break;
				}
			}
			base[enter - 1] = i % 2 + 1;
		}
	}

	public static void draw(int[] i, String[] s) {
		System.out.println(s[i[0]] + "|" + s[i[1]] + "|" + s[i[2]]);
		System.out.println("---+---+---");
		System.out.println(s[i[3]] + "|" + s[i[4]] + "|" + s[i[5]]);
		System.out.println("---+---+---");
		System.out.println(s[i[6]] + "|" + s[i[7]] + "|" + s[i[8]]);
	}

	public static int input(int[] IN) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a place:");
		try {
			int i = s.nextInt();
			if (IN[i - 1] != 0) {
				return -1;
			} else {
				return i;
			}
		} catch (Exception e) {
			return -2;
		}
	}
}
