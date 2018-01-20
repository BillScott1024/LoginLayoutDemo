import java.util.regex.Pattern;

public class ZhuCeCheck {
	private String name;
	private String password;
	private String password2; 
	
	private int flag = 1;

	UpdateExcel updateExcel= new UpdateExcel();

//	readexcel.readexcel();
		
public ZhuCeCheck(String name,String password,String password2){
	this.name = name;
	this.password = password;
	this.password2 = password2;
}

public boolean validate(){
	while(flag==1){
		
	if(this.password.equals(this.password2)&&Pattern.compile("[a-zA-Z0-9]{6,16}").matcher(this.name).matches()){
		updateExcel.updateexcel(this.name,this.password);

		flag = 0;

	}else{
		
		return false;
	}
}
	return true;
}

}