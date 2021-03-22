package Service;

import DTO.StudentDto;

import java.util.List;

public class StudentService {
    private List<StudentDto> students;
    public StudentDto Sd_Obj;

    //TO Save all List Value
    public StudentService(List<StudentDto> students) {
        this.students = students;
    }

    //TO Show all student details
    public List<StudentDto> getAllStudent() {
        return students;
    }

    //To Add the student Details
    public void save(StudentDto student) {
        students.add(student);
    }

    //To Delete the student details by Id
    public void delete(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    //To Delete All student details
    public void deleteAll() {
        students.removeAll(students);
        System.out.println("Empty Details");
    }

    //To Update the student Name
    public void update_name(int studentId, String studentName, List<StudentDto> students) {

        for (StudentDto st_dt : students) {
            if (st_dt.getId() == studentId) {
                st_dt.setName(studentName);
                students.removeIf(student -> student.getId() == studentId);
                students.add(st_dt);
            }

        }
    }


    //To Update the student age
    public void update_age(int studentId, String studentAge, List<StudentDto> students) {
        for (StudentDto st_dt : students) {
            if (st_dt.getId() == studentId) {
                st_dt.setAge(studentAge);
                students.removeIf(student -> student.getId() == studentId);
                students.add(st_dt);
            }

        }
    }

    public void update_All(int studentId, String studentName, String studentAge, List<StudentDto> students) {
        for (StudentDto st_dt : students) {
            if (st_dt.getId() == studentId) {
                st_dt.setName(studentName);
                st_dt.setAge(studentAge);
                students.removeIf(student -> student.getId() == studentId);
                students.add(st_dt);
            }

        }

    }
}
