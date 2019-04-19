package internship.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class MailSchedulerService {

    private MailService service;

    @Autowired
    public MailSchedulerService(MailService service){
        this.service = service;
    }

    private static final Logger log = LoggerFactory.getLogger(MailSchedulerService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 30000)
    public void report()  {
        //service.getSubjectsWithAvg();
        service.getSubjectsMinThanAvg();
        log.info("The time is now {}", dateFormat.format(new Date()));
        log.info("Email sent") ;
    }



}
