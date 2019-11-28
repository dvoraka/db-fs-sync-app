package dvoraka.dbfssyncapp.service;

import javax.transaction.Transactional;

public class DefaultTestingService implements TestingService {

    @Transactional
    @Override
    public void test() {

    }
}
