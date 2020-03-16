package com.pger.de.strategy.promotion;

/**
 *
 * 策略上下文context
 */
public class PromotionActivity {
    private IPromotionStrategy strategy;

    public PromotionActivity(IPromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        strategy.doPromotion();
    }
}
