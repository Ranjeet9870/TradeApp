1.Created an app with two method:-(src\main\java\tradeApp)

-getTradedInstrumentVolume -This will give the instrumentwise traded volume between the date range.
-getUnTradedInstrumentVolume -This will give list of instrument not traded between the dates.

2.Created a Feature file(Test.feature) with two scenarios for above methods.

3.Created a StepDefinition class in which we are verifying the traded and untraded instrument.

4.In TestRunner class we are mentioning the Feature file path and glue.

5.Using pom.xml file for dependencies and to run TestRunner.class file