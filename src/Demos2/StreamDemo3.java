package Demos2;
	import java.util.*;
	import java.util.stream.Collectors;

	public class StreamDemo3 {

		public static void main(String[] args) {
			List<Integer> num = new ArrayList<Integer>();
			num.add(1);
			num.add(2);
			num.add(3);
			num.add(4);
			
			
			List<Integer> squares = num.stream().map(n->n*n).collect(Collectors.toList());
			System.out.println("Square Of the numbers are "+squares);
	}
	}
