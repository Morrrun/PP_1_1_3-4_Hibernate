package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Михаил", "Александров", (byte) 25));
        users.add(new User("Александр", "Дударев", (byte) 26));
        users.add(new User("Вячеслав", "Ларев", (byte) 34));
        users.add(new User("Станислав", "Яремчук", (byte) 31));

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

//        for (User user : users) {
//            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
//        }
//
//        for (User user : userService.getAllUsers()) {
//            System.out.println(user);
//        }
//
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}
