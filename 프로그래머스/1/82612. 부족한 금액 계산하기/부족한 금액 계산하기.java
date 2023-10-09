class Solution {
    private long price;
    private long currentPrice;
    private long money;
    public long solution(int price, int money, int count) {
        init(price, money);
        return play(count);
    }
    private void init(final int price, final int money){
        this.price = price;
        this.currentPrice = price;
        this.money = money;
    }
    private void increasePrice(){
        currentPrice += price;
    }
    private void decreaseMoney(){
        money -= currentPrice;
    }
    private long play(final int count){
        for(int i = 0; i < count; i++){
            decreaseMoney();
            increasePrice();
        }
        if (!isNumberNegative()) return 0;
        return -money;
    }
    private boolean isNumberNegative(){
        return money < 0 ;
    }
}