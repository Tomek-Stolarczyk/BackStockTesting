package autotradingsim.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import autotradingsim.engine.TradingEngine;
/*12
 * Experiments apply Strategies to particular stocks over a set of time periods.
 *
 * commands: 
 * modify [arg]
 * run
 * exit	
 * 
 * implemented: 
 * handleModifyExperiment(String[] args)
 * handleModifyStrategy (String[] args)
 * ListCommands: added lists for experiment and strategy level
 * 
 *All Terminal/CLI classes go in this package.
 */

public class SimTerminal {

	private TradingEngine engine;
	
	public SimTerminal(){
		engine = new TradingEngine();
	}
	public boolean checkArgNum(String[]args, int correctnum){
		if(args.length!=correctnum){
			System.out.println("invalid number of arguments for "+args[0]);
			return false;
		}
		return true;
	}
	
	public void run()
	{
		boolean running = true;
		do {
			System.out.print("$>");
			
			String[] args = getUserInput();
			if(args == null)
				return;

			switch(args[0].toLowerCase()){
				case "h":
				case "help" :
					HandleHelp(args);
					break;
				case "viewstrat":
					TradingEngine.viewStrategy(args);
					break;
				case "modifystrat":
					if(checkArgNum(args, 2)){
						HandleModifyStrategy(args);
					}
					break;		
				case "viewex":
					TradingEngine.viewExperiment(args[1]);
					break;
				case "modifyex":
					if(checkArgNum(args, 2)){
						HandleModifyExperiment(args);
					}
					break;
				case "run":
						handleRun(args);
					break;
				case "e":
				case "exit" :
					if(checkArgNum(args, 1)){
						running = false;
					}
					break;

				case "":
					break;

				default :
					System.out.println("Please enter a valid command.");
					ListCommands("");
			}
		} while(running);
	}

	private String[] getUserInput() {
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input =	br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		if(input == null) {
			return null;
		}
		String[] args = input.split("\\s+");
		return args;
	}
	

	private void ListCommands(String operationtype) {
		if(operationtype.isEmpty()){
			System.out.println("Valid commands include:\r\n"
					+ "help [<command>]\r\n"
					+ "viewStrat <name>\r\n"
					+ "modifyStrat <name>\r\n"
					+ "viewExp <name>\r\n"
					+ "modifyExp <name>\r\n"
					+ "run <experiment_name>");
		}
		if(operationtype.equals("experiment")){
			System.out.println("Valid commands in experiment include:\r\n"
					+ "e/exit \r\n"
					+ "liststrat\r\n"
					+ "addstrat <name>\r\n"
					+ "addtime [Start YYYYMMDD] [End YYYYMMDD]\r\n"
					+ "addrandomtimeset [size] [length]\r\n"
					+ "save\r\n"
					+ "run");
		}
		if(operationtype.equals("strategy")){
			System.out.println("Valid commands in experiment include:\r\n"
					+ "e/exit \r\n"
					+ "newrule\r\n"
					+ "newcond \r\n"
					+ "newaction \r\n"
					+ "removerule\r\n"
					+ "removecond\r\n"
					+ "removeaction\r\n"
					+ "save");
		}
	}
	/**
	 * @param args
	 * Start a new loop for creation/modification of experiments.
	 * Throws IllegalArgumentExceptions
	 */
	private void HandleModifyExperiment(String[] exargs) {
		String currentExperiment=exargs[1];
		boolean running=true;
		do{
			String[] args=getUserInput();
			switch(exargs[0].toLowerCase()){
				case "e":
				case "exit": 
					running=false;
					break;
				case "h":
				case "help":
					HandleHelp(args);
					break;
				case "addstrat":
					//add existing strategies
					TradingEngine.addStrategy(currentExperiment, args);
				case "addtime":
					TradingEngine.addExpTime(currentExperiment,args);
					//add time period [Start YYYYMMDD] [End YYYYMMDD]
				case "liststrat":
					//liststrat [-a] display all or current strategies
					if(args.length==1){
						TradingEngine.viewStrategy(currentExperiment,args);
					}if(args.length==2 & args[1].equals("-a")){
						TradingEngine.viewStrategy(args);
					}break;
				case "save":
					TradingEngine.saveEx(currentExperiment);
				case "addrandomtimeset":
					//Adds a randomly generated set of time windows: size windows, each length days long.
					TradingEngine.addtimeset();
				default :
					System.out.println("Please enter a valid command.");
					ListCommands("experiment");
			}
		}while(running);
	}

	private void HandleModifyStrategy(String[] stratargs) {
		String stratname=stratargs[1];
		boolean running=true;
		do{
			String[] args=getUserInput();
			switch(args[0].toLowerCase()){
				case "e":
				case "exit": 
					running=false;
					break;
				case "newrule":
					TradingEngine.newrule(stratname);
					//prompt user to select conditions and actions from list
				case "h":
				case "help":
					HandleHelp(args);
					break;
				case "newcond":
					//define new condition
					TradingEngine.addCond(args[1]);
				case "newaction":
					//define amount to buy and sell
					TradingEngine.addAction(args[1]);
				case "removecond":
					//remove a condition from list
					TradingEngine.removeCond(args[1]);
				case "save":
					TradingEngine.saveStrat(stratname);
				default :
					System.out.println("Please enter a valid command.");
					ListCommands("strategy");
			}
		}while(running);
	}

	private void handleRun(String[] args) {
		if(args.length == 1){
			System.out.println("Running default experiment");
			return;
		}
	}
	
	private void HandleHelp(String[] args) {
		if(args.length == 1){
			System.out.println("Welcome to the auto stock trading simulator!");
			System.out.println("What do you need help with? Try: help <arg>");
		}
		else{
			String helpString = "";
			switch(args[1].toLowerCase()){
				case "viewstrat":
					helpString = "View an existing trading strategy. "
							+ "If none is specified, displays a list of "
							+ "available strategies. Usage: viewStrat [name]";
					break;
					
				case "modifystrat":
					helpString = "Modify an existing strategy, by name. "
							+ "If strategy doesn't exist, one is created by that name. "
							+ "After specifying an strategy to be modified, the prompt "
							+ "will change to Strat [name] >. See help strategyModification "
							+ "for sub-commands.\r\n"
							+ "Usage: modifyStrat [name]";
					break;	
					
				case "viewexp":
					helpString = "viewExp - view an existing experiment. If none is specified, "
							+ "displays a list of available experiments. Usage: viewExp [name]";
					break;
					
				case "modifyex":
					helpString = "Modify an existing experiment by name. If that experiment doesn't exist, "
							+ "create one under given name. After specifying a experiment to be modified, "
							+ "the prompt will change to Experiment [name] >. See help experimentModification"
							+ " for sub-commands.\r\n"
							+ "Usage: modifyExp [name]";
					break;
	
				case "run":
					helpString = "run - Runs a selected experiment. "
							+ "Usage: run [experiment_name]";
					break;

				case "experimentModification":
				case "strategyModification":
					helpString = "help for modifications not yet implemented";
					break;
					
				default:
					helpString = "Did not understand " + args[1] +
								" as a valid input. Needs to be one of viewstrat, modifystrat"
								+ ", viewexp, modifyex, run, experimentModification, or strategyModification";
					break;
			}
			System.out.println(helpString);
		}
	}
}
