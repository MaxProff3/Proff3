package hw6;

import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ContructorDAO;
import dao.ContructorDaoImpl;
import domain.Contructor;
import domain.Product;
import service.ContructorServiceImpl;
import util.HibernateUtil;

public class MainContructorTest {


	public static void main(String[] args) {
		
		Locale.setDefault(Locale.ENGLISH);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = null;
		Query query = null;
		
		try{
			session = sessionFactory.openSession();
			
			Contructor c = new Contructor("UUUUUUUUUU");
			ContructorDAO cdao = new ContructorDaoImpl(sessionFactory);
			ContructorServiceImpl csi = new ContructorServiceImpl(cdao);
			
			/*add new Contructor into DB
			csi.addNewContructor(c);
			*/
			
			/*Get id by name for reading 
			 * (to get obj add to query next line: .addEntity(Contructor.class))
			 
			query=session.createSQLQuery("select id from contructors "
					+ "where name='ФОП Пупкин'");
			List<Integer> list = query.list();
			Long temp = new Long(list.get(0));
			System.out.println(">>id="+temp);
			
			Contructor cns = csi.read(temp);
			
			System.out.println(">>Gotten obj = "+cns.getConstructorName());
			*/
			
			/*to delete obg from DB
			query=session.createSQLQuery("select * from contructors "
					+ "where name='UUUUUUUUUU'").addEntity(Contructor.class);
			List<Contructor> listCon = query.list();
			
			csi.deleteContructor(listCon.get(0));
			*/
			
			/*Update obj (if this id exists)
			query=session.createSQLQuery("select id from contructors "
					+ "where name='UUUUUUUUUU'");
			List<Integer> list = query.list();
			Long temp = new Long(list.get(0));
			c.setId(temp);
			c.setConstructorName("newUUUU");
			csi.updateContructor(c);
			*/
			
			
			//System.out.println("Метод read: "+csi.read(4l));;
			//System.out.println("!!!"+query);
			//List<Contructor> listC = csi.getAllContructors();
			//System.out.println(listC);
			
			//query = session.createSQLQuery("SELECT * FROM contructors;").addEntity(Contructor.class);
			
			
		}catch (HibernateException e) {
			System.out.println("Error!!!");
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
			System.out.println("Session is closed!");
		}
	}
}
/* 
1. Contructor, dao + service
2. Проверка, что мы можем получать список, редактировать, добавлять и удалять сущность для Contructor

3. Order + Contructor, dao + service для Order
4. Проверка что при получении заказа, заполнен контрагент
5. Проверка, что при сохранении заказа, сохраняется ссылка на контрагент

7. Order_position + Product
8. Проверка что при получении позиции заказа, заполняется ссылка на продукт
9. Проверка, что при сохранении позиции заказа, сохраняется ссылка на продукт

10. Order + Order_position
11. dao, service
12. Проверка, что при получении заказа, заполняется список позиций заказ
13. Проверка, что при сохранении заказа, сохраняются позиции заказов  
14. Попробуйте получить объект заказа из базы, для объекты вызвать геттер позиций заказов и вывести на экран.Какой результат? Какой вывод?
15. Создать новый заказ с новыми позициями, сохранить, проверить сохраняются ли позиции заказов.

Написать модульный тест для таблицы Contructor:
1. Создать базу данных proff3test для проведения тестов.
2. Создать в этой таблицы
3. Настроить, чтобы JUnit использовал эту базу.
4. Написать модульный тест, который проверяет, что в Contructor можно записать новую запись(создаем объект, save, getAll and equals).
5. Написать модульный тест, который проверяет корректность редактирования.
6. Написать модульный тест, который проверяет корректность удаления.
7. Написать модульный тест, который проверяет добавление 5 объектов и получение списка, в которых есть эти 5 объектов.


Классы и их связи:
Contructor
Order(List<Order_position> EAGER, Contructor EAGER)
Order_position(Order order, Product EAGER)

User
Product

Закладка 1:
 - поля: логин, пароль и кнопка войти
Закладка 2:
 - поля : имя и баркод
 - список продуктов
 - добавление продуктов в базу
 - редактирование продуктов
 - удаление продуктов
Закладка 3:
 - поле: имя
 - список контрагентов
 - добавление  в базу
 - редактирование
 - удаление 
Закладка 4:
 - поля: номер заказа, заказчик, менеджер(user_id), сумма заказа
 - список заказов
 - возможность выбрать заказ для просмотра на закладке 4
Закладка 5:
 - поля в заголовке документа: номер заказа, менеджер, заказчик, общая сумма
 - поля в спецификации документа: №(порядковый номер позиции), имя продукта, баркод продукта, количество, цена, сумма, 
 - интерфейс редактирования/создания? заказа
 */