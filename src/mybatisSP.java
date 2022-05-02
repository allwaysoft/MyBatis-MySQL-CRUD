
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisSP {

    public static void main(String args[]) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select a particular student  by  id
        Student student = (Student) session.selectOne("Student.callById", 3);

        //Print the student details
        System.out.println("Details of the student are:: ");
        System.out.println("Id :" + student.getId());
        System.out.println("Name :" + student.getName());
        System.out.println("Branch :" + student.getBranch());
        System.out.println("Percentage :" + student.getPercentage());
        System.out.println("Email :" + student.getEmail());
        System.out.println("Phone :" + student.getPhone());
        session.commit();
        session.close();

    }

}
