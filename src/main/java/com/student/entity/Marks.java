package com.student.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Marks {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private int score;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
