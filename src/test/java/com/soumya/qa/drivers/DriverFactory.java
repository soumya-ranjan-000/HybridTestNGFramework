package com.soumya.qa.drivers;


public enum DriverFactory {
    CHROME {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    },
    FIREFOX {
        @Override
        public DriverManager getDriverManager() {
           return new FireFoxDriverManager();
        }
    },
    MICROSOFT_EDGE{
        @Override
        public DriverManager getDriverManager() {
            return new MicrosoftEdgeDriverManager();
        }
    },
    CHROME_LAMBDATEST {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeLambdaTest();
        }
    };

    public abstract DriverManager getDriverManager();
}
