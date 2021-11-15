package com.skni.warsztatysghv2.registration;

public class StudentService {

    private final UUIDStudentIdGenerator studentIdGenerator = new UUIDStudentIdGenerator();
    private final StatusService statusService = new StatusService();
    private final ApplicationService applicationService = new ApplicationService();

    public void printStudent() {
        Student student = create(applicationService.createMock());
        System.out.println(student);
    }

    public Student create(Application application) {
        String id = studentIdGenerator.getNext();
        String firstName = application.getFirstName();
        String lastName = application.getLastName();
        String email = application.getEmail();
        Status status = statusService.randomStatus();
        return new Student(id, firstName, lastName, email, status); // new allowed here
    }

}
