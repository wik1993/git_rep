package internship;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Run {
    private static final Logger LOGGER = LoggerFactory.getLogger(Run.class);
    public static void main(String[] args) {
        LOGGER.info("Application starts");
        SpringApplication.run(Run.class, args);
    }
}
