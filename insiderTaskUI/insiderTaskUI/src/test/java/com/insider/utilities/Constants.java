package com.insider.utilities;

public class Constants {

    /*
    Eger ki xml ile olusturulan runner da browser,url,fail eden test caselerin tekrar koşum sayısı belirtilmez ise
    burada ki default değerleri alacaktır.
 */
    public static final String defaultBrowser = "chrome";
    //public static final String defaultBrowser = "firefox";
    //public static final String defaultBrowser = "headless";

    public static final String defaultUrl = "https://useinsider.com/";
    //public static final String defaultUrl ; //-> Varsa staging,qa veya preprod ortam linki eklenebilir

    public static final int defaultTestAgainCount = 0;

    public static final String qaPageLinkPath = "careers/quality-assurance/";
}
