package com.lsq.dao;

import com.lsq.pojo.Db1;

import java.util.List;

public interface Db1Mapper {
    //查询全部用户
    List<Db1> getDb1List();

    Db1 getDb1ById(int id);
}
