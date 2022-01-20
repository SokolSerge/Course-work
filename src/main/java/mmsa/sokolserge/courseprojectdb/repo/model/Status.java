package mmsa.sokolserge.courseprojectdb.repo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="statuses")
public class Status {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String statusName;

    public Long getId(){
        return this.id;
    }

    public String getStatusName(){
        return this.statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
