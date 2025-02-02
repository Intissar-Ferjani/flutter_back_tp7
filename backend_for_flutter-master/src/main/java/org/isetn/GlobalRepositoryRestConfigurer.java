package org.isetn;

import org.isetn.entities.Classe;

import org.isetn.entities.Etudiant;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class GlobalRepositoryRestConfigurer implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.setReturnBodyOnCreate(true);
        repositoryRestConfiguration.setReturnBodyOnUpdate(true);

        repositoryRestConfiguration.exposeIdsFor(Etudiant.class, Classe.class);
        repositoryRestConfiguration.getCorsRegistry()
            .addMapping("/**")
            .allowedOrigins("http://localhost:4200")
            .allowedOrigins("*")
            .allowedHeaders("*")
            .allowedMethods("OPTIONS","HEAD", "GET", "PUT", "POST", "DELETE", "PATCH" );
    }
}
