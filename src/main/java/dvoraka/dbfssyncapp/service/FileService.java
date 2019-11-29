package dvoraka.dbfssyncapp.service;

import java.io.IOException;

public interface FileService {

    void saveFile(String filename) throws IOException;
}
