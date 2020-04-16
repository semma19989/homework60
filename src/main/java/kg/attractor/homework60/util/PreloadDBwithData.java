package kg.attractor.homework60.util;


import kg.attractor.homework60.model.Comment;
import kg.attractor.homework60.model.Publication;
import kg.attractor.homework60.model.Users;
import kg.attractor.homework60.repository.CommentRepository;
import kg.attractor.homework60.repository.PublicationRepository;
import kg.attractor.homework60.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class PreloadDBwithData {
    Random r = new Random();

    @Bean
    CommandLineRunner initDatabase(UsersRepository ur, PublicationRepository pr,
                                   CommentRepository cr) {
        return (args) -> {
            ur.deleteAll();
            pr.deleteAll();
            cr.deleteAll();

            var user = Users.random();
            user.setMail("admin");
            user.setPassword("admin");
            ur.save(user);

            List<Users> users = Stream.generate(Users::random)
                    .limit(10)
                    .collect(toList());
            ur.saveAll(users);

            List<Publication> posts = Stream.generate(() -> Publication.addPost(users.get(r.nextInt(users.size()))))
                    .limit(2)
                    .collect(toList());
            pr.saveAll(posts);

            List<Comment> comments = Stream.generate(() -> Comment.addComment(users.get(r.nextInt(users.size())), posts.get(r.nextInt(posts.size()))))
                    .limit(10)
                    .collect(toList());
            cr.saveAll(comments);
            System.out.println("done");
        };
    }

}
