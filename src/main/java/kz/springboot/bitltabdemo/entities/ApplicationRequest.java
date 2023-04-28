package kz.springboot.bitltabdemo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "course_name")
    private String course_name;
    @Column(name = "commentary")
    private String commentary;
    @Column(name = "phone")
    private String phone;
    @Column(name = "handled")
    private boolean handled;
}
