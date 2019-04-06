import com.boilfish.ShortURL.dao.ManageDAOImpl;
import com.boilfish.ShortURL.model.UrlM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class urlSearchTest {
    public static void main(String args[]){
        ManageDAOImpl test = new ManageDAOImpl();
        List<UrlM> urlList = test.selectUrlByLongURL("google");
        System.out.println(urlList.toString());
    }

}
