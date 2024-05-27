package org.govstack.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice {


    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://ghd-app-cac-s-govstackcms.azurewebsites.net/en/news/?search_field=Automation%20Test_ZuK1Z&category=&startDate=2024-05-27&endDate=2024-05-27");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()='Dismiss all alerts']")).click();
        WebElement ele=driver.findElement(By.xpath("//div[@class='gs-feed-list-meta']"));
        System.out.println(ele.findElements(By.tagName("a")).getFirst());
    }
}