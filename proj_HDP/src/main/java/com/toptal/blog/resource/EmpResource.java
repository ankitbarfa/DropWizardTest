package com.toptal.blog.resource;

import com.toptal.blog.model.Emp;
import com.toptal.blog.model.Part;
import com.toptal.blog.representation.Representation;
import com.toptal.blog.service.EmpService;
import org.eclipse.jetty.http.HttpStatus;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/emp")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")

public class EmpResource {
    private final EmpService empService;

    public EmpResource(EmpService empService) {
        this.empService = empService;
    }
    @GET
    public Emp getEmp(){
        return new Emp(HttpStatus.OK_200,empService.getEmp()) ;


    }

}
