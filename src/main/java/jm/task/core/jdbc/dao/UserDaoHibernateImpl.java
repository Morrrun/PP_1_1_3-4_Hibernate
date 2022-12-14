package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private final String INSERT_INTO = "INSERT INTO users (name, lastname, age) VALUES(%s, %s, %d)";
    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()){
            session.beginTransaction();
            try {
                session.createSQLQuery("CREATE TABLE users" +
                                "(" +
                                "    id       BIGINT auto_increment PRIMARY KEY," +
                                "    name     VARCHAR(100) NOT NULL," +
                                "    lastname VARCHAR(100) NOT NULL," +
                                "    age      INT          NOT NULL" +
                                ")" +
                                "    COLLATE = utf8_general_ci")
                        .executeUpdate();
            } catch (PersistenceException pe) {
                System.out.println("Таблица уже существует!");
            }
            session.getTransaction().commit();

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()){
            session.beginTransaction();
            try {
                session.createSQLQuery("DROP TABLE users").executeUpdate();
            } catch (PersistenceException pe) {
                System.out.println("Таблицы не существует!");
            }
            session.getTransaction().commit();

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()){
            session.beginTransaction();

            session.createSQLQuery("INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)")
                    .setParameter(1, name)
                    .setParameter(2, lastName)
                    .setParameter(3, age)
                    .executeUpdate();

            session.getTransaction().commit();

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()){
            session.beginTransaction();

            session.createSQLQuery("DELETE FROM users WHERE id = " + id)
                    .executeUpdate();

            session.getTransaction().commit();

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Session session = Util.getSessionFactory().openSession()){
            session.beginTransaction();

            users = session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();

            session.getTransaction().commit();

        } catch (Exception err) {
            err.printStackTrace();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()){
            session.beginTransaction();

            session.createSQLQuery("DELETE FROM users").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
