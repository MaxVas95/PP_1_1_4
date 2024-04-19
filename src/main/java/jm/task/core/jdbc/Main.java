package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;



import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        System.out.println("Создана таблица");

        userService.saveUser("Ivan", "Ivanov", (byte) 20);
        System.out.println("User с именем — 'Ivan' добавлен в базу данных");
        userService.saveUser("Maxim", "Maximov", (byte) 25);
        System.out.println("User с именем — 'Maxim' добавлен в базу данных");
        userService.saveUser("Ilya", "Sidorov", (byte) 31);
        System.out.println("User с именем — 'Ilya' добавлен в базу данных");
        userService.saveUser("Petr", "Petrov", (byte) 38);
        System.out.println("User с именем — 'Petr' добавлен в базу данных");

        List<User> users = userService.getAllUsers();
        System.out.println("Список всех пользователей:");
        for (User user : users) {
            System.out.println(user.toString());
        }

        userService.cleanUsersTable();
        System.out.println("Таблица пользователей очищена");

        userService.dropUsersTable();
        System.out.println("Таблица пользователей удалена");
    }
}
