package Service;

import DTO.StudentDto;

import java.util.List;

public class StudentService {
    private List<StudentDto> students;

    /**
     * TO Save all List Value
     *
     * @param students : students
     */
    public StudentService(List<StudentDto> students) {
        this.students = students;
    }

    /**
     * TO Show all student details
     *
     * @return students list
     */
    public List<StudentDto> getAllStudent() {
        return students;
    }

    /**
     * To Add the student Details
     *
     * @param student : student
     */
    public void save(StudentDto student) {
        students.add(student);
    }

    /**
     * To Delete the student details by Id
     *
     * @param studentId : studentId
     */
    public void delete(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    /**
     * To Delete All student details
     */
    public void deleteAll() {
        students.removeAll(students);
        System.out.println("Empty Details");
    }
    /**
     * To Update the student name by ID
     *
     * @param studentId : studentId
     * @param studentName : studentName
     * @param students : students
     */
    public void update_name(int studentId, String studentName, List<StudentDto> students) {
        for (StudentDto sdObj : students) {
            if (sdObj.getId() == studentId) {
                sdObj.setName(studentName);
                students.removeIf(student -> student.getId() == studentId);
                students.add(sdObj);
                break;
            }
        }
    }

    /**
     * To Update the student age by Id
     *
     * @param studentId : studentId
     * @param studentAge : studentAge
     * @param students : students
     */
    public void update_age(int studentId, String studentAge, List<StudentDto> students) {
        for (StudentDto sdObj : students) {
            if (sdObj.getId() == studentId) {
                sdObj.setAge(studentAge);
                students.removeIf(student -> student.getId() == studentId);
                students.add(sdObj);
                break;
            }
        }
    }

    /**
     * TO update all data row wise by ID
     *
     * @param studentId : studentId
     * @param studentName : studentName
     * @param studentAge : studentAge
     * @param students : students
     */
    public void update_All(int studentId, String studentName, String studentAge, List<StudentDto> students) {
        for (StudentDto st_dt : students) {
            if (st_dt.getId() == studentId) {
                st_dt.setName(studentName);
                st_dt.setAge(studentAge);
                students.removeIf(student -> student.getId() == studentId);
                students.add(st_dt);
                break;
            }
        }
    }
}
