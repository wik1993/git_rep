package internship.service;

import internship.model.Mark;
import internship.model.Student;
import internship.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.stream.Collectors;

@Service
public class MailService {

    private JavaMailSender sender;

    private MarkService markService;

    private StudentService studentService;

    private SubjectService subjectService;

    @Autowired
    public MailService(JavaMailSender sender, MarkService markService, StudentService studentService, SubjectService subjectService) {
        this.sender = sender;
        this.markService = markService;
        this.studentService = studentService;
        this.subjectService = subjectService;

    }


    public void weeklyMarksReportToResponsible() {
        for (Student stud : studentService.findAllStudents()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stud.getFirstName()).append("\'s results: ");
            for (Subject sub : subjectService.findAllSubjects()) {
                Double avg = markService.findAllMarksByStudentAndSubject(stud, sub).stream().collect(Collectors.averagingInt(Mark::getValue));
                stringBuilder.append(sub);
                stringBuilder.append("marks average: ").append(avg).append(". ");
            }
            sendWeeklyMarksReportToResponsible(stud, stringBuilder);
        }
    }

    public void getSubjectsMarksMinThanAvg() {
        for (Student stud : studentService.findAllStudents()) {
            for (Subject sub : subjectService.findAllSubjects()) {
                Double avg = markService.findAllMarksByStudentAndSubject(stud, sub).stream().collect(Collectors.averagingInt(Mark::getValue));
                if (avg < 5.00){
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(stud.getFirstName()).append("\'s results: ");
                    stringBuilder.append(sub);
                    stringBuilder.append("marks average: ").append(avg).append(". ");
                    sendGetSubjectsMarksMinThanAvg(stud, stringBuilder);
                }
            }
        }
    }


    public void sendWeeklyMarksReportToResponsible(Student student,StringBuilder stringBuilder) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(student.getResponsibleEmail());
            helper.setText(stringBuilder.toString());
            helper.setSubject(student.getFirstName() + "'s average mark per Subject");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
        sender.send(message);
    }

    public void sendGetSubjectsMarksMinThanAvg(Student student,StringBuilder stringBuilder){
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(student.getResponsibleEmail());
            helper.setText(stringBuilder.toString());
            helper.setSubject(student.getFirstName() + "'s average grade lower than minimum necessary");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
        sender.send(message);
    }

}
