package teacher.service;

import teacher.entity.Student;

import java.util.Scanner;

public class TeacherService {
    private static Student[] students = null;

    public void showMenu(){
        System.out.println("Hansi emeliyyati yerine yetirmek isteyirsiniz? ");
        System.out.println("0. Ilk defe yaratmaq \n " +
                "1. yenisini yaratmaq \n " +
                "2. yenileme(update) \n " +
                "3. silmek \n " +
                "4. axtarmaq \n " +
                "5. hamisini gormek \n ");
        int action = new Scanner(System.in).nextInt();
        if(action == 0) {
            students = initializeTeachers();
        }else if(action == 1){
            students = initializeNewTeachers(students);
        }else if(action == 2){
            System.out.println("Necenci muellimi yenilemek isteyirsiniz? ");
            int updateCount = new Scanner(System.in).nextInt();
            System.out.println("Hansi xanani update elemek isteyirsiniz? (name, surname, age, subject, gender");
            String updateField = new Scanner(System.in).nextLine();
            System.out.println("Yenilenme: ");
            String Text = new Scanner(System.in).nextLine();
            switch (updateField){
                case "name":
                    students[updateCount-1].setName(Text);
                    break;
                case "surname":
                    students[updateCount-1].setSurname(Text);
                    break;
                case "subject":
                    students[updateCount-1].setSubject(Text);
                    break;
                case "gender":
                    students[updateCount-1].setGender(Text);
                    break;
                case "age":
                    students[updateCount-1].setAge(Integer.parseInt(Text));
            }

        }else if(action == 3){
            System.out.println("Necenci muellimi silmek isteyirsiniz? ");
            int muellimiSil =  new Scanner(System.in).nextInt();
            students[muellimiSil-1] = null;
        }else if(action == 5){
            if(students == null){
                System.out.println("Hec bir muellim yoxdur");
            }else{
                printAll(students);
            }
        }else if(action == 4){
            System.out.println("Axtarmaq istediyiniz muellimin adini ve soyadini daxil edin: ");
            String text = new Scanner(System.in).nextLine();
            for (int i = 0; i < students.length; i++) {
                if(students[i]==null) continue;
                if(students[i].getName().equals(text) || students[i].getSurname().equals(text)){
                    System.out.println(students[i]);
                }
            }
        }
    }
    public Student[] initializeNewTeachers(Student[] oldStudents){

        System.out.println("Nece nefer yaratmaq isteyirsiniz?");
        int additionalCount = new Scanner(System.in).nextInt();
        Student[] newStudents = new Student[oldStudents.length+additionalCount];
        for (int i = 0; i < oldStudents.length; i++) {
            newStudents[i]= oldStudents[i];
        }
        for(int i = oldStudents.length; i< newStudents.length; i++){
            newStudents[i]=requireAndCreate();
        }
        return newStudents;
    }
    public Student[] initializeTeachers(){
        System.out.println("Nece muellim daxil edeceksiniz? ");
        int count = new Scanner(System.in).nextInt();

        Student[] students = new Student[count];
        for (int i = 0; i < students.length; i++) {
            System.out.println((i + 1) + ". muellim");

            students[i] = requireAndCreate();
        }
        printAll(students);
        return students;

    }
    public Student requireAndCreate(){
        Student student = new Student();

        System.out.println("Muellimin adini daxil edin: ");
        student.setName(new Scanner(System.in).nextLine());

        System.out.println("Muellimin soyadini daxil edin: ");
        student.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Muellimin yasini daxil edin: ");
        student.setAge(new Scanner(System.in).nextInt());

        System.out.println("Muellimin tedris etdiyi fenni daxil edin: ");
        student.setSubject(new Scanner(System.in).nextLine());

        System.out.println("Muellimin genderini daxil edin: ");
        student.setGender(new Scanner(System.in).nextLine());

        return student;
    }
    public void printAll(Student[] students){
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null) continue;
            System.out.println((i+1)+". muellim");
            System.out.println(students[i]);
        }
    }
}
