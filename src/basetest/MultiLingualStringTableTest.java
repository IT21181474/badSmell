package basetest;

import static org.junit.Assert.assertEquals;

import base.MultiLingualStringTable;
import base.MultiLingualStringTable.LanguageSetting;
import org.junit.Test;

public class MultiLingualStringTableTest {

    @Test
    public void testEnglishMessages() {
        MultiLingualStringTable.setLanguage(LanguageSetting.English);
        assertEquals("Enter your name:", MultiLingualStringTable.getMessage(0));
        assertEquals("Welcome", MultiLingualStringTable.getMessage(1));
        assertEquals("Have a good time playing Abominodo", MultiLingualStringTable.getMessage(2));
    }

    @Test
    public void testKlingonMessages() {
        MultiLingualStringTable.setLanguage(LanguageSetting.Klingon);
        assertEquals("'el lIj pong:", MultiLingualStringTable.getMessage(0));
        assertEquals("nuqneH", MultiLingualStringTable.getMessage(1));
        assertEquals("QaQ poH Abominodo", MultiLingualStringTable.getMessage(2));
    }

    @Test
    public void testDefaultLanguage() {
        // Default language is English
        assertEquals("Enter your name:", MultiLingualStringTable.getMessage(0));
        assertEquals("Welcome", MultiLingualStringTable.getMessage(1));
        assertEquals("Have a good time playing Abominodo", MultiLingualStringTable.getMessage(2));
    }
}
