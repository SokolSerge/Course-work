package mmsa.sokolserge.courseprojectdb.repo.model;
import javax.persistence.*;


@Entity
@Table(name = "product_groups")
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_type", nullable = false)
    private String groupType;

    public ProductGroup(String groupType) {
        this.groupType = groupType;
    }

    public ProductGroup() {

    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public Long getId() {
        return id;
    }
}