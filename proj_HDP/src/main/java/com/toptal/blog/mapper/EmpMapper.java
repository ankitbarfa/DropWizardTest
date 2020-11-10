package com.toptal.blog.mapper;

import com.toptal.blog.model.Emp;
import com.toptal.blog.model.Part;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpMapper implements ResultSetMapper<Emp> {
    private static final String ID = "id";
    private static final String NAME = "name";
    public Emp  map(int i , ResultSet resultSet , StatementContext statementContext) throws SQLException {

        return new Emp(resultSet.getString(ID),resultSet.getString(NAME));
    }
}
