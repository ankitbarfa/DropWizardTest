package com.toptal.blog.service;

import com.toptal.blog.dao.EmpDao;
import com.toptal.blog.model.Emp;

public class EmpService {

    private EmpDao empDao;

    public EmpService(EmpDao empDao) {
        this.empDao = empDao;
    }
//comment
    public Emp getEmp(){
        return empDao.getemp();
    }

}
