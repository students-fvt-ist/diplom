package ru.sfedu.mydiplom;

import java.io.IOException;
import org.junit.Test;
import ru.sfedu.mydiplom.utils.ConfigurationUtil;


/**
 *
 * @author seyran
 */
public class MainTest {
    

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() throws IOException {
        System.out.println(ConfigurationUtil.getConfigurationEntry(Constants.PATH_CSV_STORE));
    }    
}
