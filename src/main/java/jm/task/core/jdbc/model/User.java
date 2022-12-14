package jm.task.core.jdbc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Setter @Getter
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }


    @Override
    public String toString() {
        return String.format("%-12s %-20s \n    %-9s %-20d \n    %-9s %-20d\n",
                "Пользователь:", name + " " + lastName, "Возраст", age, "id", id);
    }
}
