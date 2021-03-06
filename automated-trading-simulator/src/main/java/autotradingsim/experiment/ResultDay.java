package autotradingsim.experiment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import autotradingsim.strategy.IDecision;
import autotradingsim.util.Pair;

public class ResultDay {

	private List<String> decisionStrings;
	private List<IDecision> decisions;
	private LocalDate date;
	private BigDecimal openingBalance;
	private BigDecimal closingBalance;
	private Map<String, Integer> numShares = new HashMap<>();


	/**
	 * ResultDay is the output for each eay from runExperiment.
	 * @param date LocalDate
	 * @param openingBalance
	 */
	public ResultDay(LocalDate date,  
			BigDecimal openingBalance) {
		
		this.decisions = new ArrayList<IDecision>();
		this.date = date;
		this.openingBalance = openingBalance;
		//Start by assuming no changes are going to happen
		this.closingBalance = openingBalance;
		
		//TODO hack string for results
		this.decisionStrings = new ArrayList<String>();
	}
	
	public ResultDay(LocalDate date, 
					List<IDecision> decisions, 
					BigDecimal openingBalance, 
					BigDecimal closingBalance) {
		
		this(date, openingBalance);
		this.decisions = decisions;
	}


	public void setNumShares(String symbol, int numShares){
		this.numShares.put(symbol, numShares);
	}
	
	public Map<String, Integer> getNumShares(){
		return this.numShares;
	}

	public BigDecimal getBalanceRelativeChange(){
    	return this.getOpeningBalance().subtract(this.getClosingBalance());
    }
    
    public LocalDate getDate(){
    	return this.date;
    }
    
    public void setClosingBalance(BigDecimal closingBalance){
    	this.closingBalance = closingBalance;
    }
    
    public List<IDecision> getDecisions(){
    	return this.decisions;
    }
    
    public void addDecision(IDecision decision){
    	this.decisions.add(decision);
    }

    public BigDecimal getOpeningBalance(){
    	return this.openingBalance;
    }
    
    public BigDecimal getClosingBalance(){
    	return this.closingBalance;
    }

	public void addDecision(String decisionString) {
		this.decisionStrings.add(decisionString);
	}
	
	public List<String> getDecisionStrings(){
		return this.decisionStrings;
	}

}
