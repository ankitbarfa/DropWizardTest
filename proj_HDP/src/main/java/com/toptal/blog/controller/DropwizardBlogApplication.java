package com.toptal.blog.controller;

import com.toptal.blog.resource.EmpResource;
import com.toptal.blog.service.EmpService;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Environment;

import javax.sql.DataSource;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;

//import com.toptal.blog.auth.DropwizardBlogAuthenticator;
//import com.toptal.blog.auth.DropwizardBlogAuthorizer;
//import com.toptal.blog.auth.User;
import com.toptal.blog.config.DropwizardBlogConfiguration;
import com.toptal.blog.health.DropwizardBlogApplicationHealthCheck;
import com.toptal.blog.resource.PartsResource;
import com.toptal.blog.service.PartsService;

public class DropwizardBlogApplication extends Application<DropwizardBlogConfiguration> {
    private static final String SQL = "sql";
    private static final String DROPWIZARD_BLOG_SERVICE = "Dropwizard blog service";
    private static final String BEARER = "Bearer";

    public static void main(String[] args) throws Exception {
        new DropwizardBlogApplication().run(args);
    }

    @Override
    public void run(DropwizardBlogConfiguration configuration, Environment environment) {
        // Datasource configuration
        final DataSource dataSource =
                configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

        // Register Health Check
        DropwizardBlogApplicationHealthCheck healthCheck =
                new DropwizardBlogApplicationHealthCheck(dbi.onDemand(PartsService.class));
        environment.healthChecks().register(DROPWIZARD_BLOG_SERVICE, healthCheck);

        // Register OAuth authentication
//        environment.jersey()
//                .register(new AuthDynamicFeature(new OAuthCredentialAuthFilter.Builder<User>()
//                        .setAuthenticator(new DropwizardBlogAuthenticator())
//                        .setAuthorizer(new DropwizardBlogAuthorizer()).setPrefix(BEARER).buildAuthFilter()));
//        environment.jersey().register(RolesAllowedDynamicFeature.class);

        // Register resources
        environment.jersey().register(new PartsResource(dbi.onDemand(PartsService.class)));
        //environment.jersey().register(new EmpResource(dbi.onDemand(EmpService.class)));
    }
}