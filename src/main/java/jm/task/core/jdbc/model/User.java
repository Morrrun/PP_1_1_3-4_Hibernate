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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id) && name.equals(user.name) && lastName.equals(user.lastName) && age.equals(user.age);
    }

    @Override
    public int hashCode() {
        int res = id.hashCode();
        res += name.hashCode();
        res += lastName.hashCode();
        res += age.hashCode();
        res = 31 * res + (id.hashCode() * name.hashCode() * lastName.hashCode() * age.hashCode());
        return res;
    }

    @Override
    public String toString() {
        return String.format("%-12s %-20s \n    %-9s %-20d \n    %-9s %-20d\n",
                "Пользователь:", name + " " + lastName, "Возраст", age, "id", id);
    }
}
