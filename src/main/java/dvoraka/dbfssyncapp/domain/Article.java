package dvoraka.dbfssyncapp.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Article {

    private String title;
    private String text;
    private File file;
}
