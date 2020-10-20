package admin.api;



import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.authority.AuthorityUtils;

import com.google.common.collect.Sets;

import admin.api.entities.MongoAccessToken;
import admin.api.entities.MongoApproval;
import admin.api.entities.MongoAuthorizationCode;
import admin.api.entities.MongoClientDetails;
import admin.api.entities.MongoUser;

import org.jboss.logging.Logger;
//@SpringBootApplication
//public class AdminApplication {
//
//    public static void main(String[] args) {
//    	SpringApplication.run(AdminApplication.class, args);
//    }
//    
//}
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class AdminApplication {

    private static org.jboss.logging.Logger LOGGER = LoggerFactory.logger(AdminApplication.class);

    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(AdminApplication.class, args);
    
    
        if (args .length > 0 && "init".equalsIgnoreCase(args[0])) {
            LOGGER.info("Start initializing the sample oauth data");

            MongoTemplate mongoTemplate = (MongoTemplate) context.getBean(MongoTemplate.class);

            mongoTemplate.dropCollection(MongoUser.class);
            mongoTemplate.dropCollection(MongoClientDetails.class);
            mongoTemplate.dropCollection(MongoAccessToken.class);
            mongoTemplate.dropCollection(MongoApproval.class);
            mongoTemplate.dropCollection(MongoAuthorizationCode.class);

            // init the client details
            MongoClientDetails clientDetails = new MongoClientDetails();
            clientDetails.setClientId("web-client");
            clientDetails.setClientSecret("web-client-secret");
            clientDetails.setSecretRequired(true);
            clientDetails.setResourceIds(Sets.newHashSet("project-man"));
            clientDetails.setScope(Sets.newHashSet("call-services", "call-medicine"));
            clientDetails.setAuthorizedGrantTypes(Sets.newHashSet("authorization_code", "refresh_token"));
            //clientDetails.setRegisteredRedirectUri(Sets.newHashSet("http://localhost:8083/ui/login"));
            clientDetails.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
            clientDetails.setAccessTokenValiditySeconds(60);
            clientDetails.setRefreshTokenValiditySeconds(14400);
            clientDetails.setAutoApprove(false);
            mongoTemplate.save(clientDetails);

            LOGGER.info("Finish initializing the sample oauth data");
        }
    }
}
//public class AdminApplication {
//
//
//	public static void main(String[] args) {
//	    SpringApplication.run(AdminApplication.class, args);
//	}
//	


