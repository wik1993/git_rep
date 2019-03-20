package test;

import service.*;


public class Main {


    public static void main(String[] args) {
        DBService service = DBService.getDbService();

        StudentService studentService = new StudentService();

        //SubjectService subjectService = new SubjectService();

        //UniversityService universityService = new UniversityService();

        //ProfessorService professorService = new ProfessorService();

        //MarkService markService = new MarkService();



        /*CriteriaQuery criteriaQuery = service.getCriteriaQuery(Professor.class);
        Root prof = criteriaQuery.from(Professor.class);
        Predicate cond = service.getCriteriaBuilder(service).equal(prof.get("id"), 1);
        criteriaQuery.where(cond);
        List list = (List) service.read(criteriaQuery);
        list.forEach(x-> System.out.println(x.toString()));*/

    }


}