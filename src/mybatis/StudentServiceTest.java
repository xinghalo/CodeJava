package mybatis;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by xxh on 2016/8/28.
 */
public class StudentServiceTest {
    private static StudentService studentService;

    @BeforeClass
    public static void setup(){
        studentService = new mybatis.StudentService();
    }

    @AfterClass
    public static void teardown(){
        studentService = null;
    }

    @Test
    public void testFindAllStudents(){
        List<Student> students = studentService.findAllStudents();
        Assert.assertNotNull(students);
        for(Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void testFindStudentById(){
        Student student = studentService.findStudentById(1);
        Assert.assertNotNull(student);
        System.out.println(student);
    }

    @Test
    public void testCreateStudent(){
        Student student = new Student();
        student.setStudId(3);
        student.setName("student_"+3);
        student.setEmail("student_"+3+"@email.com");
        student.setDob(new Date());
        studentService.createStudent(student);
        Student newStudent = studentService.findStudentById(3);
        Assert.assertNotNull(newStudent);
    }
}
