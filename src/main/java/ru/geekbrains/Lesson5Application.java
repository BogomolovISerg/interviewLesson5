package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.repository.StudentRepository;
import ru.geekbrains.entities.Student;

import java.util.Random;


@SpringBootApplication
public class Lesson5Application implements CommandLineRunner{

	@Autowired
	StudentRepository repository;

	@Override
	public void run(String... args) {

		for(int i=0;i<1000;i++)
			repository.save(new Student(getRandomString(10), i));

	}

	public static void main(String[] args) {
		SpringApplication.run(Lesson5Application.class, args);
	}

	public static String getRandomString(int length){
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number=random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

}
