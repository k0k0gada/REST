package humans;

abstract public class Humans {
	protected String name;
	protected double moneyAmount;

	public double getMoneyAmount() {
		this.moneyAmount = 100 * this.moneyAmount;
		this.moneyAmount = (int) this.moneyAmount;
		this.moneyAmount = this.moneyAmount / 100;
		return moneyAmount;
	}

	public void setMoneyAmount(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
}
