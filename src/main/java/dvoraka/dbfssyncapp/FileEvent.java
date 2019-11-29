package dvoraka.dbfssyncapp;

import lombok.Data;

@Data
public class FileEvent {

    private String filename;


    public FileEvent(String filename) {
        this.filename = filename;
    }
}
