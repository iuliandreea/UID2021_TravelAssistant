package com.example.travelassistant.profile_management.account

class AccountList {

    companion object {

        private var accountList: ArrayList<Account> = ArrayList()

        fun addAccount(account: Account) {
            accountList.add(account)
        }

        fun setAccount(id: Int, account: Account) {
            accountList[id] = account
        }

        fun getAccount(id: Int): Account {
            return accountList[id]
        }

        fun removeAccount(id: Int) {
            accountList.removeAt(id)
        }

        fun getAccounts(): ArrayList<Account> {
            return accountList
        }

        fun setAccounts(accounts: ArrayList<Account>) {
            accountList.clear()
            accountList.addAll(accounts)
        }

        fun setDefaultAccounts() {
            accountList.clear()

            val acc1 = Account("emily_james@yahoo.com", "emily", "Emily James")
            val acc2 = Account("george_gonzales@yahoo.com", "george", "George Gonzales")
            val acc3 = Account("anna_marinaro@yahoo.com", "anna", "Anna Marinaro")
            val acc4 = Account("john_smith@yahoo.com", "john", "John Smith")
            val acc5 = Account("alice_swift@yahoo.com", "alice", "Alice Swift")
            val acc6 = Account("thomas_michaels@yahoo.com", "thomas", "Thomas Michaels")
            val acc7 = Account("troy_turner@yahoo.com", "troy", "Troy Turner")

            accountList.add(acc1)
            accountList.add(acc2)
            accountList.add(acc3)
            accountList.add(acc4)
            accountList.add(acc5)
            accountList.add(acc6)
            accountList.add(acc7)
        }
    }
}