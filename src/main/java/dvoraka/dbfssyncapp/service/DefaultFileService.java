package dvoraka.dbfssyncapp.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DefaultFileService implements FileService {

    @Override
    public void saveFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        Files.write(path, new byte[0]);
    }

    @Override
    public void deleteFile(String filename) throws IOException {
        Files.deleteIfExists(Paths.get(filename));
    }
}
