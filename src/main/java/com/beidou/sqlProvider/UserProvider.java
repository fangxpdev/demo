package com.beidou.sqlProvider;


import java.util.Map;

/**
 * @author beidou
 * @since 17/12/24
 */
public class UserProvider {

    public String queryByName(Map<String, Object> param) {
        String name = (String)param.get("name");
        return "select * from user where name=" + name;
    }


}
