package cafe3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MainMethod mm = new MainMethods();
		MainMethods mm1 = (MainMethods)mm;
		int menuNum;
		int CheckNumAndCountUp = 0;
		boolean oc = true;
//		String inputFoodName = br.readLine();
		while(oc) {
			menu();
			mm1.selectAll();
			menuNum = Integer.parseInt(br.readLine());
			if(menuNum>0) {
			String foodName	= mm1.checkNumAndGetName(menuNum);
			mm1.upCount(foodName);
			} else if(menuNum==0) {
				System.out.print("�߰��Ͻ� ���ĸ��� �Է����ּ���:");
				String foodName = br.readLine();
				mm1.insert(foodName);
			} else if(menuNum==00) {
				oc = false;
			} else {
				System.out.println("�߸��Է�");
			}
		
			mm1.selectAll();
	//		mm1.getCount("���");
		}
	}
	private static void menu(){
		System.out.println("��ǥ���ּ���!");
		System.out.println("���������߰� = 0");
		System.out.println("���� = 00");
	}
}
