# amazonfiltercheck
This UI automation framework 

Tech Stack used :
Selenium 
TestNg
 Awaitilty (for custom wait )
Assertj ( for Assert )
Logging slf4j 
Reprort ( Extent report not yet implemented )

Design Pattern used :

Factory Design pattern : ( Example : Browser support , Currently support CHORME(106) and firefox (104) it can be extended n number of Browsers )

Page objects  in fluent style 

How run the Test :

Make sure java 8 in stalled :

Open : testcase package : Run the individual case 
       
       All the test Run : 
       
                 mvn clean test -DsuiteXmlFile=testng.xml
