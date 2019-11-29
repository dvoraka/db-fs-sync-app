package dvoraka.dbfssyncapp;

import dvoraka.dbfssyncapp.exception.TestingException;
import dvoraka.dbfssyncapp.service.FileService;
import dvoraka.dbfssyncapp.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class App {

    @Autowired
    private FileService fileService;
    @Autowired
    private TestingService testingService;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("App");

            testingService.saveFile("test2");

            try {
                testingService.saveFileWithRollback("test3");
            } catch (TestingException e) {
            }
        };
    }
}
