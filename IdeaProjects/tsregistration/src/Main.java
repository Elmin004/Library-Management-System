import student.service.StudentService;
import teacher.service.TeacherService;

public class Main {
    private static final StudentService service = new StudentService();
//    private static final TeacherService service = new TeacherService();

    public static void main(String[] args) {
        while (true){
            service.showMenu();
        }

    };

}