import com.boilfish.ShortURL.service.UrlServerI;
import com.boilfish.ShortURL.service.UrlServerImpl;

public class CTest {
    public static void main(String[] args){
        UrlServerI url = new UrlServerImpl();
        System.out.println(url.randomCode());
        System.out.println(url.randomCode());
        System.out.println(url.randomCode());
        System.out.println(url.randomCode());
        System.out.println(url.randomCode());
        System.out.println(url.randomCode());
        System.out.println(url.randomCode());
        System.out.println(url.randomCode());

    }

}
