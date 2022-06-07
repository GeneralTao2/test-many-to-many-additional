package dev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Db {
    @Bean
    CommandLineRunner initDB(
            UserRepository userRepository,
            GroupRepository groupRepository,
            UserGroupRepository userGroupRepository
    ) {
        return args -> {
            User user = new User("tommy", "ymmot", "tommy@gmail.com");
            Group group = new Group("Coders");

            groupRepository.save(group);
            userRepository.save(user);

            UserGroup userGroup = new UserGroup();

            userGroup.setGroup(group);
            userGroup.setUser(user);
            userGroup.setActivated(true);
            userGroup.setRegisteredDate(new Date());



            userGroupRepository.save(userGroup);
        };
    }
}
