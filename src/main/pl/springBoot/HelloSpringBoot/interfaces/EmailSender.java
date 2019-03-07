package pl.springBoot.HelloSpringBoot.interfaces;

public interface EmailSender {

    void sendEmail(String to, String subject, String content);

}
