package com.beidou.dao;

import com.beidou.bean.UserInfo;
import com.beidou.bean.UserRequest;
import com.beidou.sqlProvider.UserProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author beidou
 * @since 17/12/24
 */
@Repository
public interface UserMapper {

    int saveUser(UserInfo userInfo);

    int updateUser(UserInfo userInfo);

    List<UserInfo> queryUser(UserRequest request);

    @SelectProvider(type = UserProvider.class,method = "queryByName")
    List<UserInfo> queryByName(Map<String,Object> param);

    @Select("select * from user where id=#{id}")
    UserInfo queryById(Long id);

    @Select({"<script>",
            "select * from user",
            "<where>",
            "<if test='age != null'>",
            "and age = #{age}",
            "</if>",
            "<if test='birthday != null'>",
            "and birthday = #{birthday}",
            "</if>",
            "</where>",
            "</script>"})
    List<UserInfo> queryByParam(UserRequest request);


}
