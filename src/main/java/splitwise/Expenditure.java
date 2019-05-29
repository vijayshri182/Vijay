package splitwise;

import java.util.List;

public interface Expenditure {
 public void registerExpense(Spender spend);
 public void updateTransactions(String spender,List<Spender> spendee ,int money);
}