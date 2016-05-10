package CalcProff;

//Создать целочисленный калькулятор класс Calc наследник AbstractCalc, в котором реализовать метод inChar
//      Вводимые символы такие: цифры, +, -, *, /, =
//      Будем считать, что ввод символов возможен только те, что мы определили - цифры, операции и равно.
//      Последовательность ввода такая: число1 + операция + число2 + равно.
//      Написать модульный тест для проверки:
//      1) корректного введения первого числа
//      2) корректного введения операции
//      3) корректного введения второго числа(проверка результирующего значения)
//      4) корректного введения знака "="(проверка результирующего значения)
//      Проверка при вводе чисел необходимо проверить следующее:
//      - начинающихся с 0, должно быть преобразование и "0" не должен отображаться
//      - результирующее поле должно соответсвовать набираемым символам
//      Проверка корректного ввода операции - это значит, что результирующее поле не изменилось.
//      При делении на 0 результат должен быть значение ByZero.
//      ***********************************************************************

public class AbstractCalc implements Calculator{
  private String result;
  private int temp;
  private char operation;

  AbstractCalc(){

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