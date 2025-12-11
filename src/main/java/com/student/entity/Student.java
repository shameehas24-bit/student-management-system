package com.student.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String course;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Marks> marks;
}
