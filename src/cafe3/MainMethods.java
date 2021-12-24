package cafe3;

import java.sql.Connection;
import java.util.HashMap;

public class MainMethods extends MainMethod{
	abstractMethod am = new abstractMethods();
	abstractMethods am1 = (abstractMethods)am; //다운캐스팅
	interfaceMethod im = new interfaceMethods();
	interfaceMethods im1 = (interfaceMethods)im;
	HashMap<Integer,String> numAndNameCheck = new HashMap<>();
	
	public HashMap<Integer, String> getNumAndNameCheck() {
		return numAndNameCheck;
	}
	
	@Override
	public void insert(String foodName) {
		am1.getProperties(); //프로퍼티 값 세팅
		am1.connectDatabase(am1.getThisProperties()); //데이터베이스 연결 
		im1.insertSource(am1.getThisProperties(), im1.getConn(), foodName);
	}
	
	@Override
	public void selectAll() {
		am1.getProperties();
		am1.connectDatabase(am1.getThisProperties());
		im1.selectAllSource(am1.getThisProperties());
	}
	
	@Override
	public void upCount(String foodName) {
		am1.getProperties();
		am1.connectDatabase(am1.getThisProperties());
		int beforeCount = im1.getBeforeCount(am1.getThisProperties(), im1.getConn(), foodName);
		int plusCount = im1.beforeCountPlus(beforeCount);
		im1.updateSource(am1.getThisProperties(), im1.getConn(),plusCount ,foodName);
	}
	
	public String checkNumAndGetName(int searchNum) {
		am1.getProperties();
		am1.connectDatabase(am1.getThisProperties());
		numAndNameCheck	= im1.getFoodNameAndNum(am1.getThisProperties(), searchNum);
		String foodName = numAndNameCheck.get(searchNum);
		return foodName;
	}
}
