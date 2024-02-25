package com.example.dp_spring_backend.service;


import com.example.dp_spring_backend.domain.DTO.output.CarOutputForEmailsDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulingService {

    public static final String EMAIL_SUBJECT = "Expiration date on vehicle";

    private final CarService carService;
    private final EmailService emailService;
    private static final String SCHEDULING_TIME_ZONE = "Europe/Vienna";


    @Scheduled(cron = "0 0 0 ? * MON", zone = SCHEDULING_TIME_ZONE)
    @Transactional
    public void sendNotificationAboutExpiration() {
        System.out.println("Cron job started.");

        List<CarOutputForEmailsDTO> carOutputForEmailsDTOList;
        carOutputForEmailsDTOList=carService.selectAllOldData();

        AtomicInteger emailsSent = new AtomicInteger(0);
        carOutputForEmailsDTOList.forEach(data->{
            String message = this.generateMessage(data);
            emailService.sendEmailToEmployee(EMAIL_SUBJECT,message,data.getCurrentUser().getEmail());
            emailsSent.incrementAndGet();
        });

        System.out.println("Cron job ended. Sent " + emailsSent.get() + " emails.");

    }

    private String generateMessage(CarOutputForEmailsDTO data) {
        return String.format("Hello %s,\n\n" +
                "In your inventory is %s vehicle.\n\n" +
                "Please visit the vehicle service and do the necessary control for the car.\n" +
                "Current state of car will expire %s\n\n" +
                "Kind regards \n\n" +
                "Car Management application !",
            data.getCurrentUser().getLastname(),
            data.getName(), data.getRegistration_expiration());
    }

}