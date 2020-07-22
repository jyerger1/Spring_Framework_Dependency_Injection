package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");

		// String greeting = myController.sayHello();

		System.out.println("------------ Primary Bean");
		System.out.println(myController.sayHello());

		// Below will throw error - Exception in thread "main"
		// org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean
		// named 'propertyInjectedController' available
		// go into PropertyInjectedController and add @Controller to class

		// Then you will get this error - Exception in thread "main"
		// java.lang.NullPointerException: Cannot invoke
		// "guru.springframework.sfgdi.services.GreetingService.sayGreeting()" because
		// "this.greetingService" is null
		// at
		// guru.springframework.sfgdi.controllers.PropertyInjectedController.getGreeting(PropertyInjectedController.java:13)

		// Add @Autowired to PropertyInjectedController

		// Then Spring will fail to start

		// Now add @Service to GreetingServiceImpl

		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx
				.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx
				.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
