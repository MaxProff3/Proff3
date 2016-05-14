package SecondWeek;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyCalc extends AbstractCalc {
	private int i0 = 0;
	private int res = 0;
	private char c = ' ';

	@Override
	public void inChar(char p) {
		if (this.c != ' ') {// результат обнуляем если это второе число
			this.result = "";
		}
		if (this.result == "") {// если число пишется заново , проверяем на ноль
			if (this.operation != '/' && p == '0') {
				p = ' ';
			}
		}
		if (p == '0' || p == '1' || p == '2' || p == '3' || p == '4' || p == '5' || p == '6' || p == '7' || p == '8'
				|| p == '9') {
			if (this.result.equals("0"))
				this.result = "";
			this.result += p;
			this.c = ' ';
		}
		if (p == '+' || p == '-' || p == '/' || p == '*') {
			if (this.result.equals("")) {
				return;
			}
			this.i0 = Integer.parseInt(this.result);// 12
			this.operation = p;// операцию запомнили
			this.c = p;// копировали опирацию
		}
		if (p == '=') {
			System.out.println(this.result);
			if (this.result.equals("")) {
				return;
			}
			this.temp = Integer.parseInt(this.result);
			this.result = "";
			System.out.println(this.i0);
			System.out.println(this.temp);
			if (this.operation == '+') {
				res = i0 + temp;

			}
			if (this.operation == '-') {
				res = i0 - temp;

			}
			if (this.operation == '*') {
				res = i0 * temp;

			}
			if (this.operation == '/') {
				if (temp != 0) {
					res = i0 / temp;
				}
				if (temp == 0) {
					this.result = this.ByZero;
					return;
				}

			}
			this.result += res;
		}

	}
}
