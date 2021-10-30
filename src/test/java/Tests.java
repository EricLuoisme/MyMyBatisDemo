import com.mybatis.source.demo.entity.MySqlSession;

public class Tests {

    public static void main(String[] args) {
        MySqlSession sqlSession = new MySqlSession();
        Object byId = sqlSession.findById("com.mybatis.source.demo.Department.findById", (long) 2);
        System.out.println("Answer is: " + byId.toString());
    }


}
