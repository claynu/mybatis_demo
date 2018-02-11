package com.mybatis.test;
import com.mybatis.config.StudentMapper;
import com.mybatis.config.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;
//根据配置文件生成sqlsessionfactory
/**
 * Created by heyu on 2018/1/10.
 */
public class main {
    public static void main(String[] args) throws Exception {
        //io加载配置文件
        InputStream in=Resources.getResourceAsStream("com/mybatis/config/configuration.xml");
        //用构建器构建一个inputstream
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);

        SqlSession session=factory.openSession();
       //取得mapper对象 调用mapper方法
        StudentMapper mapper=session.getMapper(StudentMapper.class);
        Student student=new Student();
//        for(int i=1540611001;i<1540611028;i++) {
//            student.setUsername(i);
//            student.setPassword("123456");
//            mapper.insertStudent(student);
//        }
        //student.setUsername(1371225458);
//        System.out.print(student.getUsername());
        List<Student> studentList=mapper.selectAllStudent();
        for (Student student1:studentList) {
            System.out.println(student1.getUsername());
        }

        //mapper.deleteOneById(1371225458);
        List<Student> studentList1=mapper.selectAllStudent();
        System.out.print(studentList1.size());
        //记得提交 不提交等于啥都没干
        session.commit();
        //关闭资源
        session.close();
        }
    }