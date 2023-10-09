package com.lou.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ComandRunner implements CommandLineRunner {

    @Value("${spring.web.loginUrl}")
    private String loginUrl;
    @Value("${spring.web.googleExecute}")
    private String googleExecutePath;
    @Value("${spring.auto.openUrl}")
    private boolean isOpen;

    @Override
    public void run(String... args) {
        if (isOpen) {
            List<String> cmd = new ArrayList<>();
            cmd.add(googleExecutePath);
            cmd.add(loginUrl);

            ProcessBuilder processBuilder = new ProcessBuilder(cmd);

            try {
                Process process = processBuilder.start();
                // wait process finished
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("Command executed successfully");
                } else {
                    System.err.println("Command executed failed with exit code: " + exitCode);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
