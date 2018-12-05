import com.boilfish.ShortURL.dao.UrlDAOImpl;
import com.boilfish.ShortURL.model.UrlM;

import java.util.Date;

public class insertTest {
    public static void main(String[] args){
        UrlM url1=new UrlM();
        url1.setShortUrl("gr5tl1");
        url1.setLongUrl("http://www.baidu.com");
        url1.setUserId(0);
        url1.setTimeStamp(new Date());
        UrlDAOImpl dao = new UrlDAOImpl();
        int i=dao.insertUrl(url1);
        System.out.println(i);
        System.out.println("---------");
    }
}
