package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.MouseOverPage;

import static pages.MouseOverPage.MouseOverType.COMPASS;

public class MouseOverTests extends BaseTest {

    // POM, but with no method chaining
    @Test
    public void testMouseOverCaption() {
        IndexPage indexPage = new IndexPage(getDriver());
        MouseOverPage mouseOverPage = indexPage.getMouseOverPage();
        mouseOverPage.hoverOverElement(COMPASS);
        Assert.assertTrue(mouseOverPage.getHint(COMPASS).isDisplayed());
    }

    // This is clean, but breaks the separation of concerns principle:
    //      page structure and user actions from the validation logic
    // Also leads to potential issues with reusability, readability and flexibility
    @Test
    public void testMouseOverCaption2() {
        new IndexPage(getDriver())
                .getMouseOverPage()
                .hoverOverElement(COMPASS)
                .verifyHintShown(COMPASS);
    }

}