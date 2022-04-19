/*
 * package com.example.library;
 * 
 * import org.apache.commons.logging.Log; import
 * org.apache.commons.logging.LogFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Component; import
 * com.example.library.model.User; import
 * com.example.library.service.UserService;
 * 
 * @Component public class ApplicationCommandRunner implements CommandLineRunner
 * {
 * 
 * protected final Log logger = LogFactory.getLog(getClass());
 * 
 * @Autowired UserService userService;
 * 
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * logger.
 * info("Welcome to the runner from commandLineRunner to test JPA mapping 1:n");
 * 
 * User user = new User("U006","Lesly", "Jhones", 1975);
 * 
 * userService.save(user);
 * 
 * 
 * }
 * 
 * }
 */