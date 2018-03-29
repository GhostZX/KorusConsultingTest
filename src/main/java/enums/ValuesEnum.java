package enums;

public enum ValuesEnum {
    GOOGLE_URL("https://www.google.ru"),
    GOOGLE_TITLE("Google"),
    SEARCH_REQUEST("Корус Консалтинг, Рахманов Александр Юрьевич"),
    RESULTS_TITLE("Корус Консалтинг, Рахманов Александр Юрьевич - Поиск в Google"),
    TOOLTIP_TEXT("Поиск"),
    TITLE("title");

    public String text;

    ValuesEnum(String text) {
        this.text = text;
    }
}
