package com.hyuk.hyukweb.study.pracitce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InterAuto {

    public static void main(String[] args) {
        // ChromeDriver 위치를 시스템 속성에 설정
        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        // Chrome 옵션 설정 (headless 모드 실행)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // 브라우저 창 없이 실행하려면 이 옵션 사용
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        // WebDriver 객체 생성
        WebDriver driver = new ChromeDriver(options);

        try {
            // 1. 티켓팅 페이지로 이동
            driver.get("https://tickets.interpark.com/special/sports/promotion?seq=43");

            // 2. 로그인 페이지로 이동하여 로그인 수행 (예시)
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            WebElement usernameInput = driver.findElement(By.id("tig05205"));
            WebElement passwordInput = driver.findElement(By.id("asd027911"));

            usernameInput.sendKeys("your-username");
            passwordInput.sendKeys("your-password");

            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            // 3. 특정 공연 페이지로 이동
            driver.get("https://www.example.com/ticket");

            // 4. 예매 버튼을 클릭
            WebElement ticketButton = driver.findElement(By.id("ticket-button"));
            ticketButton.click();

            // 5. 티켓 수량 선택 및 예매 완료
            WebElement quantityInput = driver.findElement(By.id("quantity"));
            quantityInput.sendKeys("1");

            WebElement buyButton = driver.findElement(By.id("buy-button"));
            buyButton.click();

            // 결과 출력
            System.out.println("예매가 완료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // WebDriver 종료
            driver.quit();
        }
    }

}
