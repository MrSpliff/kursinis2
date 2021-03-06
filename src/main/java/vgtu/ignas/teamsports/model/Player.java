package vgtu.ignas.teamsports.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", unique = true, nullable = false)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer rank;
    private Integer userType; // 0 - regular user, 1 - admin

    @JsonIgnore
    @OneToMany
    private Set<Review> reviewSet;

    @JsonIgnore
    @ManyToMany
    private Set<PlayEvent> playEvents = new HashSet<PlayEvent>(0); // <-- what is this Hashset here? No such thing in a (!working) Location


    // Constructors

    public Player() {}

    public Player(@NotNull String username, @NotNull String password, @NotNull String email, @NotNull Integer rank, Integer userType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.rank = rank;
        this.userType = userType;
    }


    // Getters and Setters

    @JsonGetter("id")
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @JsonGetter("username")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @JsonGetter("password")
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @JsonGetter("email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @JsonGetter("rank")
    public Integer getRank() { return rank; }
    public void setRank(Integer rank) { this.rank = rank; }

    @JsonGetter("user_type")
    public Integer getUserType() { return userType; }
    public void setUserType(Integer userType) { this.userType = userType; }

    public Set<PlayEvent> getPlayEvents() {
        return playEvents;
    }
    public void setPlayEvents(Set<PlayEvent> playEvents) {
        this.playEvents = playEvents;
    }

    public Set<Review> getReviewSet() {
        return reviewSet;
    }
    public void setReviewSet(Set<Review> reviewSet) {
        this.reviewSet = reviewSet;
    }

}