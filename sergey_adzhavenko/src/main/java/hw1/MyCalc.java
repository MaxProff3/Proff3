package hw1;

public class MyCalc extends AbstractCalc{
	
	private char last;
	
	public void inChar(char p){
		if(result.equals(ByZero)){
			result="0";
			temp=0;
			last=0x0;
		}
		if(p=='-' || p=='+' || p=='*' || p=='/' || p=='='){
			if(last=='-' || last=='+' || last=='*' || last=='/' || last=='=' || operation==0x0){
				operation=p;
			}
			else {
				if(operation=='-')result=Integer.toString(temp-Integer.parseInt(result));
				else if(operation=='+')result=Integer.toString(temp+Integer.parseInt(result));
				else if(operation=='*')result=Integer.toString(temp*Integer.parseInt(result));
				else if(operation=='/'){
					try{
					result=Integer.toString(temp/Integer.parseInt(result));
					}catch(Exception e){result=ByZero;}
				}
				operation=p;
			}
		}
		else{
			if(last=='-' || last=='+' || last=='*' || last=='/' || last=='='){
				temp=Integer.parseInt(result);
				result="0";
			}
			if(result.length()<9)result=result+p;	
			try{
				int clear = Integer.parseInt(result);
				result=Integer.toString(clear);
			}catch(Exception e){}
		}
		last=p;
	}
}


