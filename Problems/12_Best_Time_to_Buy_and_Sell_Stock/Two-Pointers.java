
class Solution {
    public int maxProfit(int[] prices) {
        
        // edge case when given prices array is empty
        if(prices == null || prices.length == 0) return 0;

        int lowest = prices[0];
        int max_profit = 0;

        for (int i = 0; i < prices.length; i++) {
            
            // Check if the price of the day is lower than yesterday
            // and keep track of lowest price so far 
            if (prices[i] < lowest) {
                lowest = prices[i];
                
            // When the price today is not lower than yesterday
            // check if selling today would make the most profit
            } else if (prices[i] - lowest > max_profit)
                max_profit = prices[i] - lowest;
            
        }
        return max_profit;
    }
}

/*
Slight variation:

class Solution {
    public int maxProfit(int[] prices) {
        
    int profit = 0;
    int iBuy = 0; 
        
    for(int i = 0; i<prices.length; i++){
        
        // Keep track of the index of lowest price
        if(prices[iBuy] > prices[i]) iBuy = i;
        
        // Calculate the profit of buying at lowest price
        // and selling at current day
        profit = Math.max(profit, prices[i] - prices[iBuy]);
    }
        
    return profit;
    }
}
*/
