package dvoraka.dbfssyncapp.service;

import dvoraka.dbfssyncapp.domain.File;
import dvoraka.dbfssyncapp.exception.TestingException;
import dvoraka.dbfssyncapp.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class DefaultTestingService implements TestingService {

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileService fileService;


    @Transactional
    @Override
    public void saveFile(String filename) {

        File file = new File();
        file.setName(filename);

        fileRepository.save(file);

        try {
            fileService.saveFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional(rollbackOn = TestingException.class)
    @Override
    public void saveFileWithRollback(String filename) throws TestingException {

        File file = new File();
        file.setName(filename);

        fileRepository.save(file);

        try {
            fileService.saveFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new TestingException();
    }
}
