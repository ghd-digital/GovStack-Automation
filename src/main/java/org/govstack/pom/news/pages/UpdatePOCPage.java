package org.govstack.pom.news.pages;

import org.govstack.pom.locators.UpdatePOCLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UpdatePOCPage {

    UpdatePOCLocators updatePOCloc = new UpdatePOCLocators();
    CommonMethods key = new CommonMethods();

    String existingpostName = "donot delete";
    String namebefore = updatePOCloc.existingpost.getText();
    String updateTxt = "_updatename";
    String updatedpostName;

    public void SelectExistingPost() {
        try {
            for (WebElement ele : updatePOCloc.postlist)
                if (ele.getText().contains(existingpostName)) {
                    key.clickElement(ele);
                    break;
                }
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public void UpdateExistingPost() throws InterruptedException {
        try {
            key.sendTextToElement(updatePOCloc.name, updateTxt);
            key.clickElement(updatePOCloc.save1);
            key.clickElement(updatePOCloc.save2);
            Thread.sleep(10000);
            key.clickElement(updatePOCloc.back);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public void VerifyUpdatedPost() {
        try {
            updatedpostName = getTextofElement(updatePOCloc.existingpost);
            Assert.assertEquals(updatedpostName, namebefore + updateTxt);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public String getTextofElement(WebElement ele) {
        String txt = ele.getText();
        return txt;
    }
}