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
import java.util.HashMap;
import java.util.Map;
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


    public void reportMarksToResponsible(Student student, Map<Subject, Double> map) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        StringBuilder subjectAndAverageOfThis = new StringBuilder();
        subjectAndAverageOfThis.append(student.toString());
        map.forEach((k,v) -> subjectAndAverageOfThis.append(k.toString()).append(v.toString()));

        try {
            helper.setTo(student.getResponsibleEmail());
            helper.setText(subjectAndAverageOfThis.toString());
            helper.setSubject(student.getFirstName() + " Your child marks average per subject The average grade lower than minimum necessary");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
        sender.send(message);
    }

    public void report(Student student,StringBuilder stringBuilder){
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

    public void getSubjectsWithAvg() {

        for (Student stud : studentService.findAllStudents()) {
            Map<Subject, Double> subjectAndAverage = new HashMap<>();
            for (Subject sub : subjectService.findAllSubjects()) {
                Double avg = markService.findAllMarksByStudentAndSubject(stud, sub).stream().collect(Collectors.averagingInt(Mark::getValue));
                subjectAndAverage.put(sub, avg);
            }
            reportMarksToResponsible(stud, subjectAndAverage);
        }
    }

    public void getSubjectsMinThanAvg() {

        for (Student stud : studentService.findAllStudents()) {
            for (Subject sub : subjectService.findAllSubjects()) {
                Double avg = markService.findAllMarksByStudentAndSubject(stud, sub).stream().collect(Collectors.averagingInt(Mark::getValue));
                StringBuilder stringBuilder = new StringBuilder();
                if (avg < 5.00){
                    stringBuilder.append(stud.getFirstName()).append(sub).append(avg);
                }
                report(stud, stringBuilder);
            }
        }
    }


}
