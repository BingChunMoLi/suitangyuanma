import com.beans.Websites;
import com.dao.IDao;
import com.dao.WebSiteDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebSiteDaoTest {

    @org.junit.jupiter.api.Test
    void insert() {
        IDao dao = new WebSiteDao();
        Websites g = new Websites();
        g.setName("阿里");
        g.setUrl("alibaba");
        g.setCountry("zh-cn");
        dao.Insert(g);

    }

    @org.junit.jupiter.api.Test
    void delete() {
    }
}
