package me.nathanmiller.animusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import me.nathanmiller.animusic.services.StorageService;

@SpringBootApplication
public class AniMusicApplication {


	// @Autowired
	// reason for static is due to it being static method main
	//static only accessible through static
	// private static StorageService storageService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AniMusicApplication.class, args);
		
		StorageService storageService = context.getBean(StorageService.class);
	// should get filenames one by one
	// when app starts itll look for srevices be picked up //// as a bean and manage it and connect to space
	System.out.println(storageService.getSongFileNames());
		
	}

}
