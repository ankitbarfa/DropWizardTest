package com.toptal.blog.dao;


import com.toptal.blog.mapper.EmpMapper;
import com.toptal.blog.model.Emp;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(EmpMapper.class)
public interface EmpDao {
    @SqlQuery("select * from emp;")
    public Emp getemp();
}
