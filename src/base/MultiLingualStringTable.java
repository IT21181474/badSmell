package base;

/**
 * MultiLingualStringTable class supports multiple languages for messages.
 * The language can be set using setLanguage method.
 * Messages can be retrieved using getMessage method.
 * 
 * Note: Currently supports English and Klingon.
 * 
 * @author Kevan Buckley, maintained by __student
 * @version 2.0, 2014
 */
public class MultiLingualStringTable {

    public enum LanguageSetting { English, Klingon }

    private static LanguageSetting currentLanguage = LanguageSetting.English;

    private static String[] englishMessages = { "Enter your name:", "Welcome", "Have a good time playing Abominodo" };
    private static String[] klingonMessages = { "'el lIj pong:", "nuqneH", "QaQ poH Abominodo" };

    /**
     * Sets the current language.
     * 
     * @param language The language to set.
     */
    public static void setLanguage(LanguageSetting language) {
        currentLanguage = language;
    }

    /**
     * Retrieves the message for the given index in the current language.
     * 
     * @param index The index of the message.
     * @return The message.
     */
    public static String getMessage(int index) {
        if (currentLanguage == LanguageSetting.English) {
            return englishMessages[index];
        } else {
            return klingonMessages[index];
        }
    }
}
