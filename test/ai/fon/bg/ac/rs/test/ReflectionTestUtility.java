package ai.fon.bg.ac.rs.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import zadatak1.Televizor;

/**
 * Utility methods for invoking usual reflection methods.
 * 
 * @author Nikola Milikic
 *
 */
public class ReflectionTestUtility {
	
	/**
	 * Returns a value of a field named 'fieldName' from the passed object.
	 * 
	 * @param obj	object to retrieve the field value from
	 * @param fieldName	field name
	 * @param failMessage	message to be written with a failed test in case there is no field with the given name
	 * @return	value of the field (to be casted to the proper type)
	 */
	public static Object getFieldValue(Object obj, String fieldName, String failMessage) {
		try {
			// collect all fields from the obj class and all super classes
			List<Field> result = new ArrayList<Field>();

		    Class<?> clazz = obj.getClass();
		    while (clazz != null && clazz != Object.class) {
		        Collections.addAll(result, clazz.getDeclaredFields());
		        clazz = clazz.getSuperclass();
		    }
		    
		    // iterate through all fields
		    for (Field field : result) {
				if (field.getName().equals(fieldName)) {
					field.setAccessible(true);
					
					return field.get(obj);
				}
			}
		    // if the field is not found, test has failed
		    fail(failMessage);
		} catch (IllegalAccessException e1) {
			fail(failMessage);
		}
		return null;
	}
	
	/**
	 * Returns a field modifier.
	 * 
	 * @param obj	object from whose class to fetch the field modifier
	 * @param fieldName	field name
	 * @param failMessage	message to be written with a failed test in case there is no field with the given name
	 * @return	int representation of a modifier
	 */
	public static int getFieldModifier(Object obj, String fieldName, String failMessage) {
		try {
			Field field = obj.getClass().getDeclaredField(fieldName);
			
			return field.getModifiers();
		} catch (NoSuchFieldException e1) {
			fail(failMessage);
		}
		return -1;
	}
	
	/**
	 * Returns a method modifier.
	 * 
	 * @param obj	object from whose class to fetch the method modifier
	 * @param methodName	method name
	 * @param failMessage	message to be written with a failed test in case there is no method with the given name and parameter types
	 * @param parameterTypes	array with method parameter types
	 * @return	int representation of a modifier
	 */
	public static int getMethodModifiers(Object obj, String methodName, String failMessage, Class<?>[] parameterTypes) {
		try {
			Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
			
			return method.getModifiers();
		} catch (Exception e1) {
			fail(failMessage);
		}
		return -1;
	}
	
	/**
	 * Returns a constructor modifier.
	 * 
	 * @param obj	object from whose class to fetch the constructor modifier
	 * @param failMessage	message to be written with a failed test in case there is no constructor with the given parameter types
	 * @param parameterTypes	array with constructor parameter types
	 * @return	int representation of a modifier
	 */
	public static <T> int getConstructorModifiers(T obj, String failMessage, Class<?>[] parameterTypes) {
		try {
			Constructor<? extends Object> constructor = obj.getClass().getDeclaredConstructor(parameterTypes);
			
			return constructor.getModifiers();
		} catch (Exception e1) {
			fail(failMessage);
		}
		return -1;
	}
	
	public void runInABlock(Runnable block1) {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));
			
			block1.run();

			Televizor t1 = new Televizor(false, "LG OLED65", -1);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("NE ispisuje se rec GRESKA u slucaju greske", ispis.trim().equalsIgnoreCase("GRESKA"));
			
			int programValue1 = (int) getFieldValue(t1, "program", "U klasi nije definisan atribut program");
			assertEquals("Za prosledjeni treci argument \"0\", atribut program ima vrednost \""+programValue1+"\", sto je van granica", 1, programValue1);
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}
}
