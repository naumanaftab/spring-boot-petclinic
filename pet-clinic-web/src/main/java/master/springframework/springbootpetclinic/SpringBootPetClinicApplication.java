package master.springframework.springbootpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootPetClinicApplication extends SpringBootServletInitializer {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return configureApplication(builder);
//    }
//
//    public static void main(String[] args) {
//        configureApplication(new SpringApplicationBuilder()).run(args);
//    }
//
//    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
//        return builder.sources(SpringBootPetClinicApplication.class).bannerMode(Banner.Mode.OFF);
//    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPetClinicApplication.class, args);
    }
}
