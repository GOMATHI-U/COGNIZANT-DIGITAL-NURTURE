package spring_dateformat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringDateformatApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringDateformatApplication.class, args);

		displayDate();
	}

	public static void displayDate() {

		try {

			ApplicationContext context =
					new ClassPathXmlApplicationContext("date-format.xml");

			SimpleDateFormat format =
					context.getBean("dateFormat", SimpleDateFormat.class);

			Date date = format.parse("31/12/2018");

			System.out.println("Parsed Date : " + date);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}