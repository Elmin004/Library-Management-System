package student.service;

import teacher.entity.Student;

import java.util.Scanner;

public class StudentService {
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
            students = initializeStudents();
        }else if(action == 1){
            students = initializeNewStudents(students);
        }else if(action == 2){
            System.out.println("Necenci telebeni yenilemek isteyirsiniz? ");
            int updateCount = new Scanner(System.in).nextInt();
            System.out.println("Hansi xanani update elemek isteyirsiniz? (name, surname, age, gender");
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
                case "gender":
                    students[updateCount-1].setGender(Text);
                    break;
                case "age":
                    students[updateCount-1].setAge(Integer.parseInt(Text));
            }

        }else if(action == 3){
            System.out.println("Necenci telebeni silmek isteyirsiniz? ");
            int muellimiSil =  new Scanner(System.in).nextInt();
            students[muellimiSil-1] = null;
        }else if(action == 5){
            if(students == null){
                System.out.println("Hec bir telebe yoxdur");
            }else{
                printAll(students);
            }
        }else if(action == 4){
            System.out.println("Axtarmaq istediyiniz telebenin adini ve soyadini daxil edin: ");
            String text = new Scanner(System.in).nextLine();
            for (int i = 0; i < students.length; i++) {
                if(students[i]==null) continue;
                if(students[i].getName().equals(text) || students[i].getSurname().equals(text)){
                    System.out.println(students[i]);
                }
            }
        }
    }
    public Student[] initializeNewStudents(Student[] oldStudents){

        System.out.println("Nece nefer yaratmaq isteyirsiniz?");
        int additionalCount = new Scanner(System.in).nextInt();
        Student[] newStudents = new Student[oldStudents.length+additionalCount];
        for (int i = 0; i < oldStudents.length; i++) {
            newStudents[i]=oldStudents[i];
        }
        for(int i= oldStudents.length;i< newStudents.length;i++){
            newStudents[i]=requireAndCreate();
        }
        return newStudents;
    }
    public Student[] initializeStudents(){
        System.out.println("Nece telebe daxil edeceksiniz? ");
        int count = new Scanner(System.in).nextInt();

        Student[] students = new Student[count];
        for (int i = 0; i < students.length; i++) {
            System.out.println((i + 1) + ". telebe");

            students[i] = requireAndCreate();
        }
        printAll(students);
        return students;

    }
    public Student requireAndCreate(){
        Student student = new Student();

        System.out.println("Telebenin adini daxil edin: ");
        student.setName(new Scanner(System.in).nextLine());

        System.out.println("Telebenin soyadini daxil edin: ");
        student.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Telebenin yasini daxil edin: ");
        student.setAge(new Scanner(System.in).nextInt());

        System.out.println("Telebenin tedris aldigi fenni daxil edin: ");
        student.setSubject(new Scanner(System.in).nextLine());

        System.out.println("Telebenin genderini daxil edin: ");
        student.setGender(new Scanner(System.in).nextLine());

        return student;
    }
    public void printAll(Student[] students){
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null) continue;
            System.out.println((i+1)+". telebe");
            System.out.println(students[i]);
        }
    }
}
