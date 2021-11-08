package com.lsq.mapper;

import com.lsq.Utils.MybatisUtils;
import com.lsq.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
//方法一:
//List<User> users =
        session.selectList("com.lsq.mapper.UserMapper.selectUser");
//方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }
}
