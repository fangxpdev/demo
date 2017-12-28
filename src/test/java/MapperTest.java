import com.beidou.bean.UserInfo;
import com.beidou.bean.UserRequest;
import com.beidou.dao.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author beidou
 * @since 17/12/25
 */
public class MapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testsaveUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("111");
        userInfo.setAge(12);
        userInfo.setPhone("18077778888");
        userInfo.setBirthday(20021201);
        userInfo.setAddr("浙江");
        int res = userMapper.saveUser(userInfo);
        System.out.println(res);
    }

    @Test
    public void testupdateUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("111");
        userInfo.setAge(12);
        userInfo.setPhone("18077778888");
        userInfo.setBirthday(20021202);
        userInfo.setAddr("浙江");
        userInfo.setId(1L);
        userMapper.updateUser(userInfo);
    }

    @Test
    public void testqueryUser() {
        UserRequest request = new UserRequest();
        request.setAge(12);
        List<UserInfo> userInfos = userMapper.queryUser(request);
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo);
        }
    }

    @Test
    public void testqueryByName() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "111");
        List<UserInfo> userInfos = userMapper.queryByName(map);
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo);
        }
    }

    @Test
    public void testqueryById() {
        UserInfo userInfo = userMapper.queryById(1L);
        System.out.println(userInfo);
    }


    @Test
    public void testqueryByParam() {
        UserRequest request = new UserRequest();
        request.setAge(12);
        request.setBirthday(20021202);
        List<UserInfo> userInfos = userMapper.queryByParam(request);
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo);
        }
    }

}
