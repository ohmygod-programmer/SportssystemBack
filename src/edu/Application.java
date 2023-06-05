package edu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import edu.exceptions.IndexException;
import edu.index.Indexer;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner buildIndex(Indexer indexer) throws IndexException {
        return (ApplicationArguments args) -> {
            try {
                indexer.indexPersistedData("edu.entity.Sportsman");
                indexer.indexPersistedData("edu.entity.Trainer");
                indexer.indexPersistedData("edu.entity.Building");
                indexer.indexPersistedData("edu.entity.Competition");
            }
            catch (Throwable e){
                e.printStackTrace();
            }
        };
    }
}