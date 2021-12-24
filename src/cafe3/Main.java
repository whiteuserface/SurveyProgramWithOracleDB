package cafe3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MainMethod mm = new MainMethods();
		MainMethods mm1 = (MainMethods)mm;
		int menuNum;
		String stringNum;
		boolean oc = true;
//		String inputFoodName = br.readLine();
		while(oc) {
			menu();
			try {
				mm1.selectAll();
				menuNum = Integer.parseInt(br.readLine());
				if(menuNum>0) {
					mm1.upCount(mm1.checkNumAndGetName(menuNum));
				} else if(menuNum==0) {
					System.out.print("추가하실 음식명을 입력해주세요:");
					String foodName = br.readLine();
					mm1.insert(foodName);
				} else if(menuNum == -10) {
					oc = false;
				} else {
					System.out.println("잘못입력");
				}
			
				} catch(NumberFormatException e) {
					e.printStackTrace();
				}
			
			mm1.selectAll();
		}
	}
	private static void menu(){
		System.out.println("투표해주세요!");
		System.out.println("음식종류추가 = 0");
		System.out.println("종료 = -10");
	}
}
