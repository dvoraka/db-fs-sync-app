package dvoraka.dbfssyncapp;

import dvoraka.dbfssyncapp.exception.TestingException;
import dvoraka.dbfssyncapp.repository.FileRepository;
import dvoraka.dbfssyncapp.service.FileService;
import dvoraka.dbfssyncapp.service.TestingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.io.IOException;

@Slf4j
@EnableJpaRepositories
@SpringBootApplication
public class App {

    @Autowired
    private FileService fileService;
    @Autowired
    private TestingService testingService;
    @Autowired
    private FileRepository fileRepository;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("App");

            fileService.deleteFile("test2");
            fileService.deleteFile("test3");

            testingService.saveFile("test2");

            try {
                testingService.saveFileWithRollback("test3");
            } catch (TestingException e) {
            }

            log.info("Files: {}", fileRepository.findAll());
        };
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void rollbackListener(FileEvent event) {
        log.info("Event: {}", event);
        try {
            fileService.deleteFile(event.getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
