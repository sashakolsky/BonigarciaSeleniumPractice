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

}