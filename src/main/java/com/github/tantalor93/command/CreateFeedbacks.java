package com.github.tantalor93.command;

import com.github.tantalor93.dto.FeedbackToCreate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Min;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@ShellComponent
public class CreateFeedbacks {

    @ShellMethod("create random feedbacks on provided host")
    public void createFeedbacks(
            @ShellOption(defaultValue = "1") @Min(1) final int number,
            @ShellOption(defaultValue = "localhost:8080") final String host
    ) {

        final Random random = new Random();

        final List<FeedbackToCreate> list = new LinkedList<>();
        for(int i = 0; i < number; i++) {
            final int randomInt = random.nextInt();
            final String name = "Phantom" + randomInt;
            list.add(new FeedbackToCreate(name, name + "@gmail.com", "approves"));
        }
        final RestTemplate restTemplate = new RestTemplate();

        list.stream().forEach(e -> restTemplate.postForEntity("http://" + host + "/feedbacks", e, String.class));
    }
}
