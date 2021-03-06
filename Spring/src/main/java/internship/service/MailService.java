package internship.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import internship.model.Mark;
import internship.model.Student;
import internship.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MailService {

    private JavaMailSender sender;

    private MarkService markService;

    private StudentService studentService;

    private SubjectService subjectService;

    private Configuration configuration;

    @Autowired
    public MailService(JavaMailSender sender, MarkService markService, StudentService studentService, SubjectService subjectService, Configuration configuration) {
        this.sender = sender;
        this.markService = markService;
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.configuration = configuration;
    }


    /**
     * Sending email using HTML Freemarker template
     **/

    public void weeklyMarksReportToResponsible() {
        studentService.findAllStudents().forEach(student -> {
            Map<Subject, List> subAndMarks = new HashMap<>();
            subjectService.findAllSubjects().forEach(subject -> {
                List<Mark> marks = markService.findAllMarksByStudentAndSubject(student, subject);
                subAndMarks.put(subject, marks);
            });
            try {
                sendWeeklyMarksReportToResponsible(student, subAndMarks);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    private void sendWeeklyMarksReportToResponsible(Student student, Map<Subject, List> subAndMarks) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        Map<String, Object> model = new HashMap<>();
        model.put("studName", student.getFirstName());
        model.put("subjectsAndMarks", subAndMarks);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/");
        Template t = configuration.getTemplate("reportAllMarksForSubjectsTemplate.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        try {
            helper.setTo(student.getResponsibleEmail());
            helper.setText(text, true);
            helper.setSubject(student.getFirstName() + "\'s weekly marks report");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
        sender.send(message);
    }

    public void subjectsMarksMinThanAvg() {
        studentService.findAllStudents().forEach(student -> {
            Map<Subject, Double> subAndAvg = new HashMap<>();
            subjectService.findAllSubjects().forEach(subject -> {
                Double avg = markService.findAllMarksByStudentAndSubject(student, subject).stream().collect(Collectors.averagingInt(Mark::getValue));
                if (avg < 5.00) {
                    subAndAvg.put(subject, avg);
                }
            });
            if (subAndAvg.size() != 0) {
                try {
                    sendGetSubjectsMarksMinThanAvg(student, subAndAvg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void sendGetSubjectsMarksMinThanAvg(Student student, Map<Subject, Double> subAndAvg) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        Map<String, Object> model = new HashMap<>();
        model.put("studName", student.getFirstName());
        model.put("subjectsAndAvg", subAndAvg);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/");
        Template t = configuration.getTemplate("reportMinThanAvgTemplate.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        try {
            helper.setTo(student.getResponsibleEmail());
            helper.setText(text, true);
            helper.setSubject(student.getFirstName() + "\'s average grade lower than minimum necessary");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
        sender.send(message);
    }


    public void weeklyAvgMarksReportToResponsible() {
        studentService.findAllStudents().forEach(student -> {
            Map<Subject, Double> subAndAvg = new HashMap<>();
            subjectService.findAllSubjects().forEach(subject -> {
                Double avg = markService.findAllMarksByStudentAndSubject(student, subject).stream().collect(Collectors.averagingInt(Mark::getValue));
                subAndAvg.put(subject, avg);
            });
            try {
                sendWeeklyAvgMarksReportToResponsible(student, subAndAvg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    private void sendWeeklyAvgMarksReportToResponsible(Student student, Map<Subject, Double> subAndAvg) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        Map<String, Object> model = new HashMap<>();
        model.put("studName", student.getFirstName());
        model.put("subjectsAndAvg", subAndAvg);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/");
        Template t = configuration.getTemplate("reportMinThanAvgTemplate.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        try {
            helper.setTo(student.getResponsibleEmail());
            helper.setText(text, true);
            helper.setSubject(student.getFirstName() + "\'s weekly marks average report");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
        sender.send(message);
    }


    /** Sending email using String Builder**/
/*

    public void weeklyMarksAvgReportToResponsible() {
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
            StringBuilder stringBuilder = new StringBuilder();
            for (Subject sub : subjectService.findAllSubjects()) {
                Double avg = markService.findAllMarksByStudentAndSubject(stud, sub).stream().collect(Collectors.averagingInt(Mark::getValue));
                if (avg < 5.00){
                    stringBuilder.append(sub);
                    stringBuilder.append("marks average: ").append(avg).append(". ");
                }
            }
            if(stringBuilder.length() != 0){
            sendGetSubjectsMarksMinThanAvg(stud, stringBuilder);}
        }
    }


    public void sendWeeklyAvgMarksReportToResponsible(Student student,StringBuilder stringBuilder) {
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
*/

}
