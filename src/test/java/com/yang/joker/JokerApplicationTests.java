package com.yang.joker;
import com.yang.joker.entity.student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JokerApplicationTests {

	@Test
	public void contextLoads() {
		//
		try {
			Class clazz=Class.forName("com.yang.joker.entity.student");
//			Object inst = clazz.newInstance();
//			Method logMethod = clazz.getDeclaredMethod("printX", String.class);
//            logMethod.setAccessible(true);
//					logMethod.invoke(inst, "yang");

			Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, String.class, int.class);
			student instance = (student) constructor.newInstance("张三", "145", 18);
			System.out.println("调用构造方法 == "+instance.getName()+"，"+instance.getLevel());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.print("not found!");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
