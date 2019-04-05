import com.boilfish.ShortURL.dao.ManageDAOImpl;

import java.util.Calendar;
import java.util.Date;

public class selectUserCountDAOTest {
    public static void main(String args[]){
        ManageDAOImpl manageDAO = new ManageDAOImpl();
        int i = manageDAO.selectUserCount();
        System.out.println(i);
        System.out.println("---------");
        i = manageDAO.selectNewUserCount();
        System.out.println(i);
        System.out.println("---------");
        i = manageDAO.selectNewUrlCount();
        System.out.println(i);
        System.out.println("---------");
        i = manageDAO.selectUrlCount();
        System.out.println(i);
        System.out.println("---------");
    }
}
