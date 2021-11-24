package com.lsq.dao;

import com.lsq.Utils.MybatisUtils;
import com.lsq.pojo.Db1;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Db1MapperTest {
    @Test
    public void test() {
        //第一步：获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();

        try {
            //方式一:getMapper
            Db1Mapper Db1Mapper = sqlSession.getMapper(Db1Mapper.class);
            List<Db1> db1List = Db1Mapper.getDb1List();

            //方法二:getMapper
            //   sqlSession.selectList("com.lsq.dao.Db1Mapper.getDb1List")

            for (Db1 db1 : db1List) {
                System.out.println(db1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getDb1ById() {
    SqlSession sqlSession = MybatisUtils.getSession();

    Db1Mapper mapper = sqlSession.getMapper(Db1Mapper.class);
        Db1 db1 = mapper.getDb1ById(1);
        System.out.println(db1);
    }
}







