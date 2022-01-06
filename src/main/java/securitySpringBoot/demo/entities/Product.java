package securitySpringBoot.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3,max = 25)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCat")
    protected Category category;
    @NotNull
    @Size(min = 2,max = 100)
    private String description;
    private int quantite;
    @DecimalMin(value="100")
    private Double price;
//    @Column(nullable = true, length = 64)
    private String photos;

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;

        return "/product-photos/" + id + "/" + photos;
    }



}
