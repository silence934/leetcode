package xyz.nyist.leetcode.begin2000;

/**
 * @author: silence
 * @Date: 2022/3/18 10:23
 * @Description:
 */
public class Solution2043 {

    private long[] balance;

    public Solution2043(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;
        if (account1 >= balance.length || account1 < 0 || account2 >= balance.length || account2 < 0) {
            return false;
        }
        if (balance[account1] < money) {
            return false;
        }
        balance[account1] = balance[account1] - money;
        balance[account2] = balance[account2] + money;

        return true;
    }

    public boolean deposit(int account, long money) {
        account--;
        if (account >= balance.length || account < 0) {
            return false;
        }
        balance[account] = balance[account] + money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        account--;
        if (account >= balance.length || account < 0) {
            return false;
        }
        if (balance[account] < money) {
            return false;
        }
        balance[account] = balance[account] - money;
        return true;
    }


}
