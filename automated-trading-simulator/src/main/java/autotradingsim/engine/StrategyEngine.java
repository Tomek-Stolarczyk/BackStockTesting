package autotradingsim.engine;

import java.math.BigDecimal;
import java.util.Set;

import autotradingsim.application.ITradingApplication;
import autotradingsim.application.TradingApplication;
import autotradingsim.strategy.IAction;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.simpleimpl.*;
import autotradingsim.strategy.Strategy;
import autotradingsim.strategy.ICondition.Comparator;

public class StrategyEngine {
	public ITradingApplication appEngine;
	public IStrategy currentStrategy;
	
	public StrategyEngine() {
		// TODO Auto-generated constructor stub
		 appEngine = TradingApplication.getInstance();
	}
	public IStrategy createDefaultStrategy() {
		// TODO Auto-generated method stub
		IStrategy newstrat = new Strategy();
		appEngine.saveStrategy(newstrat);
		return newstrat;
	}

	public IStrategy addNewSimpleStrategy(String stratname, int cselection, int cvalue, int aselection, int avalue) {
		if(appEngine.saveStrategy(new SimpleStrategy(stratname, "",(cselection == 1) ? Comparator.GT : Comparator.LT,
				new BigDecimal(cvalue),(aselection == 1) ? IAction.ActionType.BUY : IAction.ActionType.SELL, avalue))){
			return appEngine.getStrategy(stratname.hashCode());
		}else{
			return null;
		}
		
	}

	public IStrategy viewStrategy(String stratname) {
		// TODO Auto-generated method stub
		return(appEngine.getStrategy(stratname.hashCode()));
	}

}
