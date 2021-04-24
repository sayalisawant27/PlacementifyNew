package dypimr.placementcell.placementify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "course")
public class Course  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cuid",nullable = false,updatable = false)
    private long cuid;
    private String courseName;
    private String collegeName;
    private int duration;
    private String university;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Batch> batches=new HashSet<>();
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> students=new HashSet<>();

    @Override
    public String toString() {
        return "Course{" +
                "cuid=" + cuid +
                ", courseName='" + courseName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", duration=" + duration +
                ", university='" + university + '\'' +
                '}';
    }
}
