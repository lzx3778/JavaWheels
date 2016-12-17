package tryPack;

public class BreakSign {
	public BreakSign(){
		FOR:
			while(true){
				for(int i = 0;i < 10;i++){
					System.out.println("in loop");
					break FOR;
				}
				System.out.println("error");
			}
		System.out.println("breaked loop");
	}
}
