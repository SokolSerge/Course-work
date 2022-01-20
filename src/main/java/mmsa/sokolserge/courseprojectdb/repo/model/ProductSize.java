package mmsa.sokolserge.courseprojectdb.repo.model;
import javax.persistence.*;


@Entity
@Table(name = "product_sizes")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size_type", nullable = false)
    private String sizeType;

    public ProductSize(){
    }

    public ProductSize(String sizeType) {
        this.sizeType = sizeType;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public Long getId() {
        return id;
    }
}