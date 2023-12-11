package e2e;

import org.openqa.selenium.WebDriver;

public class CandidatePage extends BasePage {
    private static String CANDIDATE_PATH = "/recruitment/viewCandidates";

    public CandidatePage(WebDriver webDriver) {
        super(webDriver);
    }
    public void visitCandidatePage(){
        visitPageURL(ORANGE_URL + CANDIDATE_PATH);
    }
}
