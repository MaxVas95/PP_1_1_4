package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();
        System.out.println("Создана таблица");

        userDao.saveUser("Ivan", "Ivanov", (byte) 20);
        System.out.println("User с именем — 'Ivan' добавлен в базу данных");
        userDao.saveUser("Maxim", "Maximov", (byte) 25);
        System.out.println("User с именем — 'Maxim' добавлен в базу данных");
        userDao.saveUser("Ilya", "Sidorov", (byte) 31);
        System.out.println("User с именем — 'Ilya' добавлен в базу данных");
        userDao.saveUser("Petr", "Petrov", (byte) 38);
        System.out.println("User с именем — 'Petr' добавлен в базу данных");

        List<User> users = userDao.getAllUsers();
        System.out.println("Список всех пользователей:");
        for (User user : users) {
            System.out.println(user.toString());
        }

        userDao.cleanUsersTable();
        System.out.println("Таблица пользователей очищена");

        userDao.dropUsersTable();
        System.out.println("Таблица пользователей удалена");
    }
}
