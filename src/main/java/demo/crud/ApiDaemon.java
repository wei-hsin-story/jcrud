package demo.crud;

import org.json.simple.parser.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class ApiDaemon {

    public static void main(String[] args) throws IOException, ParseException {


        SpringApplication.run(ApiDaemon.class, args);
    }
}
