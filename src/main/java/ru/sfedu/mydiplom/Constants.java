package ru.sfedu.mydiplom;

/**
 *
 * @author seyran
 */
public class Constants {
    public static final String GLOABL_PROR = "ru.sfedu.mydiplom.prop";
    public static final String PATH_CSV_STORE = "ru.sfedu.path.csv_store";
    public static final String PATH_XML_STORE = "ru.sfedu.path.xml_store";
    public static final String DATA_BASE_URL = "ru.sfedu.db.url";
    public static final String DATA_BASE_USER = "ru.sfedu.db.user";
    public static final String DATA_BASE_PASSWORD = "ru.sfedu.db.password";
    public static final String[] COLUMNS_APP = new String[] {"id", "sum", "maturity", "rate", "date", "status", "clientID", "typeCredit"};
    public static final String[] COLUMNS_CLT = new String[] {"id", "dateOfBirth", "status", "passportNumber", "salary", "experience", "experienceOfLastWP", "experienceOfLastWP", "totalGain", "conviction", "working", "changedPassport", "name", "placeOfWorking", "addres", "phone", "workPhone", "passportData", "otherDocument"};
    public static final String[] COLUMNS_PMT = new String[] {"id", "date", "credit"};
    public static final String[] COLUMNS_TCD = new String[] {"id", "name", "maturityOf", "maturityUp", "sumOf", "sumUp", "rateOf", "rateUp"};
    public static final String[] COLUMNS_DLY = new String[] {"id", "credit", "date", "sum"};
}
