package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int n =300;
		int i=2;
		ArrayList<Integer> a =new ArrayList<Integer>();
		while(n!=1) {
			while(n%i==0) {
				a.add(i);
				n=n/i;			
			}
			i++;
		}
		System.out.println(a);
	}

}
