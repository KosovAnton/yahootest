# mwdn_automation_task
Test cases are represented in Gherkin style:  
__@Historical_date_sorting__  
__Scenario:__ *User checks default sorting in table on tab 'Historical Data'*  
__Given__ *User opens Amazon NasdaqGS page*  
__And__ *User opens tab 'Historical Data'*  
__Then__ *User checks that history table default sorting is descending*  
  
__@Historical_date_download_data_link__  
__Scenario:__ *User checks link 'Download Data'*  
__Given__ *User opens Amazon NasdaqGS page*  
__And__ *User opens tab 'Historical Data'*  
__And__ *User clicks link 'Download Data'*  
__Then__ *User checks that file "AMZN.csv" was downloaded*
    
How to run:
- default runner: src\test\java\CucumberRunner.java (specify tags to run, @Historical_data_scenarios setted by default). You can run any tag specified in feature files.
- also there is an ability to run with maven, execute 'mvn clean verify', by default @Historical_data_scenarios will run. Also you can specify number of parallel threads and exact tags to run: mvn clean -Dcucumber.options="--tags @Historical_data_scenarios" -Dfork.count=2 verify. html report will be generated in target\cucumber-report-html\cucumber-html-reports
