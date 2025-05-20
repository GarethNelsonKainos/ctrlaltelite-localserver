package uk.nhs.hackathon.ctrlaltelite.localserver.configurator;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication(scanBasePackages = "uk.nhs.hackathon.ctrlaltelite.localserver")
@SpringBootConfiguration
public class Configurator {
    public static void main(String[] args) {
        run(Configurator.class, args);
    }
}
