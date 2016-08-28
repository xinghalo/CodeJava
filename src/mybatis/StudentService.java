package mybatis;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by xxh on 2016/8/28.
 */
public class StudentService {
    public List<Student> findAllStudents(){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try{
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        }finally {
            sqlSession.close();
        }
    }
    public Student findStudentById(Integer studId){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(studId);
        }finally {
            sqlSession.close();
        }
    }
    public void createStudent(Student student){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try{
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
}
