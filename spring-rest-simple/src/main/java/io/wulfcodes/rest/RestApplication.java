package io.wulfcodes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) { SpringApplication.run(RestApplication.class, args); }

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student();
//		student1.setId("randomuuid");
//		student1.setName("sam");
//		student1.setRollNo(35);
//		student1.setGender(Student.Gender.MALE);
//
//		Student student2 = new Student();
//		student2.setName("jhi");
//		student2.setRollNo(12);
//
//		System.out.println(student1);
//		student1.modify(student2);
//		System.out.println(student1);
//
//		System.out.println(student1.getId());
//		System.out.println(Modifier.toString(student1.getClass().getDeclaredField("id").getModifiers()));

//		// Get the handler mapping bean from the application context
//		RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
//
//		// Get all the URL mappings and their associated handler methods
//		Map<RequestMappingInfo, HandlerMethod> mappings = handlerMapping.getHandlerMethods();
//
//		// Get the base URL (including the scheme and host)
//		String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
//
//		// Print all full URLs (including domain, port, and path)
//		mappings.forEach((mapping, handlerMethod) -> {
//			mapping.getPatternsCondition().getPatterns().forEach(pattern -> {
//				// Construct the full URL
//				String fullUrl = baseUrl + pattern;
//				System.out.println("Full URL: " + fullUrl);
//			});
//		});

	}
}
