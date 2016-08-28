package mybatis;

import java.util.List;

/**
 * Created by xxh on 2016/8/28.
 */
public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
    void insertStudent(Student student);
}
