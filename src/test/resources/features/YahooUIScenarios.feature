@Historical_data_scenarios
Feature: This feature contains all scenarios which are related to tab 'Historical Data'

  @Historical_date_sorting
  Scenario: User checks default sorting in table on tab 'Historical Data'
    Given User opens Amazon NasdaqGS page
    And User opens tab 'Historical Data'
    Then User checks that history table default sorting is descending

  @Historical_date_download_data_link
  Scenario: User checks link 'Download Data'
    Given User opens Amazon NasdaqGS page
    And User opens tab 'Historical Data'
    And User clicks link 'Download Data'
    Then User checks that file "AMZN.csv" was downloaded