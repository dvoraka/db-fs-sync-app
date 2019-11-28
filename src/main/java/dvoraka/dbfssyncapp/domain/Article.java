package dvoraka.dbfssyncapp.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Article {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String text;
    @OneToOne
    private File file;
}
