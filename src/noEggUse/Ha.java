package noEggUse;

public class Ha {
	public static void main(String[] args) {
		String a= "�и���˸�Ĥ�����Х";
		int time = 0;
		for(int i = 0;i < 10;i++){
			char b=a.charAt(i);
			if(b == '��'){
				System.out.println("+1s");
				time++;
			}else{
				System.out.println("+0s");
			}
		}
		System.out.println("you have " + time + " s");
	}
}
