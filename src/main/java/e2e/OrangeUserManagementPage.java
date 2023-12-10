package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeUserManagementPage extends BasePage {
    By adminMenuItem = By.xpath("//*[@href=\"/web/index.php/admin/viewAdminModule\"]");
    By totalRecords = By.cssSelector("span.oxd-text.oxd-text--span[data-v-7b563373][data-v-0dea79bd]");
    By addButton = By.xpath("//button[normalize-space()='Add']");
    By userRoleDDL = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    By firstDDLOption = By.xpath("(//div[@role='listbox']//child::div)[2]"); // TODO Declare one variable for firstDDLOption and secondDDLOption as string and generate the element based on index in real time
    By secondDDLOption = By.xpath("(//div[@role='listbox']//child::div)[3]");
    By statusDDL = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
    By employeeNameDDL = By.xpath("//input[@placeholder='Type for hints...']"); // TODO
    By usernameField = By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
    By passwordField = By.xpath("(//input[@type='password'])[1]");
    By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    By saveButton = By.cssSelector("button[type=\"submit\"]");
    By deleteIcon = By.xpath("//i[@class='oxd-icon bi-trash']");
    By confirmDelete = By.xpath("//button[normalize-space()='Yes, Delete']");
    By usernameSearchField = By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
    By searchButton = By.xpath("//button[normalize-space()='Search']");
    By resetFilterButton = By.xpath("//button[normalize-space()='Reset']");

    public OrangeUserManagementPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickAdminMenuItem() {
        clickElement(adminMenuItem);
    }

    public void clickAddButton() {
        clickElement(addButton);
    }

    public void fillInUsernameField(String username) {
        fillInElement(usernameField, username);
    }

    public void fillInPasswordField(String password) {
        fillInElement(passwordField, password);
    }

    public void fillInConfirmPasswordField(String confirmPassword) {
        fillInElement(confirmPasswordField, confirmPassword);
    }

    public void clickSaveButton() {
        clickElement(saveButton);
    }

    public void clickDeleteIcon() {
        clickElement(deleteIcon);
    }

    public void clickConfirmDeleteModal() {
        clickElement(confirmDelete);
    }

    public void deleteFirstUserRecord() {
        clickDeleteIcon();
        clickConfirmDeleteModal();
    }

    public void fillInUsernameSearchField(String username) {
        fillInElement(usernameSearchField, username);
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }

    public Integer getTotalRecordsValue() {
        String text = getElementText(totalRecords);
        String number = text.replace("(", "").replace(")", "").replace(" Records Found", "");
        return Integer.parseInt(number);
    }

    public void findUserByUsername(String username) {
        fillInUsernameSearchField(username);
        clickSearchButton();
    }


    public void selectUserRoleDDL(String userRole) {
        clickElement(userRoleDDL);
        if (userRole == UserRoleEnum.Admin.name())
            clickElement(firstDDLOption);
        else if (userRole == UserRoleEnum.ESS.name())
            clickElement(secondDDLOption);
    }

    public void selectStatusDDL(String status) {
        clickElement(statusDDL);
        if (status == StatusEnum.Enabled.name())
            clickElement(firstDDLOption);
        else if (status == StatusEnum.Disabled.name())
            clickElement(secondDDLOption);
    }

    public void fillInEmployeeNameField(String name) {
        fillInElement(employeeNameDDL, name);
        clickElement(firstDDLOption);
    }

    public void resetFilter() {
        clickElement(resetFilterButton);
    }

    public enum UserRoleEnum {
        Admin,
        ESS
    }

    public enum StatusEnum {
        Enabled,
        Disabled
    }

}
