Feature: News Scenarios


  @RG_NW_2.1_RG_NW_2.2 @Sanity
  Scenario Outline: Create a news and publish
    Given I launch and login to the Govstack application
    When I selects the news "<TestcaseID>"
    And I enter all the details
    And I should be able to publish the news
    When I launch the News frond end application in new tab
    Then News should be posted to front end application
    Examples:
      | TestcaseID |  |
      | RG_NW_2.1      |  |

  @RG_NW_1
  Scenario: Verify News Widget is available and the following options are available and editable on the News Widget Setting
    Given I launch and login to the Govstack application
    When I selects the news
    And update News Widgets in Setting
    When I launch the News frond end application in new tab
    Then verify Widgets updated in front End



  @RG_NW_2.24
  Scenario Outline: Verify clicking Save and preview link will save the changes and direct the user to the front end news listing preview.
    Given I launch and login to the Govstack application
    When I selects the "<Content>"
    Then Verify Save and preview link is available.
    Examples:
      | Content          |  |
      | Save and Preview |  |

  @RG_NW_2.8
  Scenario Outline: Verify Unpublish: Content variation English (United States) unpublished message will be returned.
    Given I launch and login to the Govstack application
    When I selects the "<Content>"
    Then verify Status should be Unpublished
    Examples:
      | Content       |  |
      | UnPublished   |  |

  @RG_NW_2.10
  Scenario Outline: Verify Updates made on post will reflect under Posts with updated information
    Given I launch and login to the Govstack application
    When I selects the "<Content>"
    Then Verify the status of Published content
    Examples:
    |  Content   |  |
    |  Published |  |

  @RG_NW_4.1
  Scenario Outline: Verify News Widget is available and editable on the News Widget Setting.
    Given I launch and login to the Govstack application
    When I selects the "<Content>"
    Then Verify Content published message will be returned after Save and Publish.
    Examples:
    |  Content      |  |
    |  News Widget  |  |