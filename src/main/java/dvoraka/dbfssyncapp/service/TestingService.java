package dvoraka.dbfssyncapp.service;

import dvoraka.dbfssyncapp.exception.TestingException;

import java.io.IOException;

public interface TestingService {

    void saveFile(String filename) throws IOException;

    void saveFileWithRollback(String filename) throws TestingException;
}
