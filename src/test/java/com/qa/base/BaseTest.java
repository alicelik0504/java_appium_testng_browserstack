package com.qa.base;

import com.qa.utils.JsonParser;
import com.qa.utils.StringParser;
import org.json.JSONObject;
import org.testng.annotations.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public class BaseTest {
    public HashMap<String, String> strings = new HashMap<>();
    public JSONObject loginUsers;

    @Parameters({"deviceID"})
    @BeforeTest
    public void beforeTest(String deviceID) throws ParserConfigurationException, SAXException, IOException {
        DriverManager.initializeDriver(deviceID);
        strings = StringParser.parseStringXML("strings.xml");
        loginUsers = JsonParser.parse("loginUsers.json");
    }

    @AfterTest(alwaysRun = true)
    public void quit() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}
