package datajpa.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import datajpa.app.models.services.IUploadFileService;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	IUploadFileService uploadFileService;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		uploadFileService.deleteAll();
		
		uploadFileService.init();
	}

}
