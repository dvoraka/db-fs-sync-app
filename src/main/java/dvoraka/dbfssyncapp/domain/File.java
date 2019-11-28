package dvoraka.dbfssyncapp.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.nio.file.Path;

@Data
@Entity
public class File {

    private String name;
    private Path path;
}
