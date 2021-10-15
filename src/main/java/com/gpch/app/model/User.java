package com.gpch.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    @Length(min = 11, message = "*Seu cpf deve ter pelo menos 11 caracteres!")
    @NotEmpty(message = "*Informe um cpf!")
    private String userName;

    @Column(name = "email")
    @Email(message = "*Por favor, informe um e-mail válido!")
    @NotEmpty(message = "*Informe um e-mail!")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Sua senha deve ter pelo menos 5 caracteres!")
    @NotEmpty(message = "*Por favor, informe sua senha!")
    private String password;

    @Column(name = "name")
    @NotEmpty(message = "*Por favor, informe seu nome!")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "*Por favor, informe seu sobrenome!")
    private String lastName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "pontos")
    private int pontos;

    @Column(name = "score")
    private int score;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
