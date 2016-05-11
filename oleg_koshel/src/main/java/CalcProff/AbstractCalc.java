package CalcProff;

//������� ������������� ����������� ����� Calc ��������� AbstractCalc, � ������� ����������� ����� inChar
//      �������� ������� �����: �����, +, -, *, /, =
//      ����� �������, ��� ���� �������� �������� ������ ��, ��� �� ���������� - �����, �������� � �����.
//      ������������������ ����� �����: �����1 + �������� + �����2 + �����.
//      �������� ��������� ���� ��� ��������:
//      1) ����������� �������� ������� �����
//      2) ����������� �������� ��������
//      3) ����������� �������� ������� �����(�������� ��������������� ��������)
//      4) ����������� �������� ����� "="(�������� ��������������� ��������)
//      �������� ��� ����� ����� ���������� ��������� ���������:
//      - ������������ � 0, ������ ���� �������������� � "0" �� ������ ������������
//      - �������������� ���� ������ �������������� ���������� ��������
//      �������� ����������� ����� �������� - ��� ������, ��� �������������� ���� �� ����������.
//      ��� ������� �� 0 ��������� ������ ���� �������� ByZero.
//      ***********************************************************************

public class AbstractCalc implements Calculator{
  private String result;
  private int temp;
  private char operation;

  public AbstractCalc(){

      this.result = "";
      this.temp = 0;
      this.operation =' ';
  }
  
  @Override
  public void printResult(){
      System.out.println("Result = " + result);
  }
  public String getResult(){
      return result;
  }

  public void printInfo(){
      System.out.println("Result = " + result);
      System.out.println("Temp = " + temp);
      System.out.println("Operation = " + operation);

      System.out.println();

  }

  @Override
  public void inChar(char p) {

      if (p=='C'){

          result="";
          temp=0;
          operation =' ';

          return;
      }



      if ((p=='+') || (p=='-') || (p=='*') || (p=='/') || (p=='=')){


          if (p=='='){

              int resultInt= Integer.valueOf(getResult());

              if (operation=='+')   result =Integer.toString(temp+resultInt);
              if (operation=='-')   result =Integer.toString(temp-resultInt);
              if (operation=='*')   result =Integer.toString(temp*resultInt);

              if (operation=='/') {



                  if (resultInt==0){

                      result= "By zero";}
                  else {

                      result =Integer.toString(temp/resultInt);
                  }



              }






              operation=' ';
              temp=0;

          }else {

          operation = p;

          temp = Integer.valueOf(getResult());}

      } else {

          if (!getResult().equals("")) {

              if (Integer.valueOf(getResult()) == temp) {

                  result = "";
              }
          }


          result += p;

      }

      printInfo();
  }
}