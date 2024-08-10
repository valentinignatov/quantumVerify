package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import config.BaseTestConf;

public class SeleniumHooks extends BaseTestConf {

    @Before
    public void setUp() {
        super.initConfig("chrome");
    }

    @After
    public void tearDown() {
        super.quitDriver();
    }
}