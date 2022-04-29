package Demos2;
	import java.util.List;
	import java.util.stream.Collectors;
	import java.util.Arrays;

	public class StreamDemo2 {

		public static void main(String[] args) {
			List<String> names = Arrays.asList("Stella Micheal","Shee1a John","Preethi","Dhivya");
			List<String> longnames = names.stream().filter(str->str.length()>5 && str.length()<10).collect(Collectors.toList());
			
//			for(String s : longnames) {
//				System.out.println(s);
//			}
	//	
			
			longnames.forEach(System.out::println);
		}
	}


