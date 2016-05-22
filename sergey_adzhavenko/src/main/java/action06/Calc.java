package action06;

public class Calc extends AbstractCalc {
	@Override
	public void inChar(char p){
		if(p=='='){
			setResult(runOperation(getTemp(),getOperation(), getResult()));
			setOperation('0');
			setTemp(0);
		} else if('0'<=p && p<='9'){
			if(getOperation()!='0' && getTemp()==0){
				setTemp(Integer.parseInt(getResult()));
				setResult("0");
			}
				setResult(getResult() + p);
		} else {
			setOperation(p);
		}
		printResult();
	}
	public String runOperation(int a, char op, String strB){
		int b = Integer.parseInt(strB);
		switch(op){	
		case '+': return a + b + "";
		case '-': return a - b + "";
		case '*': return a * b + "";
		case '/': if(b==0) return AbstractCalc.ByZero;
		}
		return a/b+"";
	}
	@Override
	public void setResult(String k){
		try{
			k = ""+Integer.parseInt(k);
		}catch(Exception e){			
		}
		super.setResult(k);
	}
}	
