package main;

import com.mybatis.config.Student;
import com.mybatis.config.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by heyu on 18-2-11.
 */
public class mapper {
    public StudentMapper mapper()throws Exception{
        InputStream in= Resources.getResourceAsStream("com/mybatis/config/configuration.xml");
        //用构建器构建一个inputstream
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        return mapper;
    }
    public static void main(String[] args)throws Exception{
            mapper mapper =new mapper();
            Student student = mapper.mapper().selectOneById(1540610823,"123456");
            if (student!=null){
                System.out.println(student.getUsername());
                System.out.println(student.getPassword());
            }
            else
                System.out.println("login erro");


    }
}
