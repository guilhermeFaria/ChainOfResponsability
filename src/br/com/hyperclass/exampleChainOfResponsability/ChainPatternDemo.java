package br.com.hyperclass.exampleChainOfResponsability;

public class ChainPatternDemo {
	
	private static AbstractLogger getChainOfLoggers() {
		
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		
		return errorLogger;
	}
	
	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();
		
		loggerChain.logMessage(AbstractLogger.INFO, "This is an Information");
		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an Debug");
		loggerChain.logMessage(AbstractLogger.ERROR, "This is an Error");
	}
	
	
}
