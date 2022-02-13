@instagram
Feature: Instagram Automation
  We are automating instagram as a social media app to genrate automatic likes, comment and views

  @instagram_login
  Scenario Outline: Login to instagram
    Given I enter below <url>
    When I enter my username as <username> and password as <password>
    Then I click on login button

    Examples: 
      |      url     |           username          |  password  |
      | instagramUrl | amitsinghbisht321@gmail.com | hansaben@7 |
