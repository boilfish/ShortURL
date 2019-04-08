import com.boilfish.ShortURL.dao.ManageDAOImpl;
import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.model.UserM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class urlSearchTest {
    public static void main(String args[]){
        ManageDAOImpl test = new ManageDAOImpl();
        UserM testuser = new UserM();
        testuser.setMail("@126");

        System.out.println(test.selecrUserByUser(testuser,0,5));
    }

}
