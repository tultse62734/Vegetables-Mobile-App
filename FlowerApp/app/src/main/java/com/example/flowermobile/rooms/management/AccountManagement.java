package com.example.flowermobile.rooms.management;

import android.app.Application;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import com.example.flowermobile.rooms.AccountItemEntities;
import com.example.flowermobile.rooms.dao.AccountDAO;
import com.example.flowermobile.rooms.database.FlowerDatabase;


public class AccountManagement {
    private AccountDAO accountDAO;
    private Application application;

    public AccountManagement(Application application) {
        this.application = application;
        FlowerDatabase flowerDatabase = FlowerDatabase.getDatabase(application);
        accountDAO = flowerDatabase.accountDao();
    }
    public interface DataCallBack{
        void onSuccess(AccountItemEntities account);
        void onFail(String message);
    }
    private class AddAccountItemAsync extends AsyncTask<AccountItemEntities, Void, Void> {
        private AccountDAO accountDAO;
        @Override
        protected Void doInBackground(AccountItemEntities... accountItemEntities) {
            accountDAO.insertAccount(accountItemEntities);
            return null;
        }

        public AddAccountItemAsync(AccountDAO accountDAO) {
            this.accountDAO = accountDAO;
        }
    }
    private class GetAccountItemAsync extends AsyncTask<AccountItemEntities, Void, Void> {
        private AccountDAO accountDAO;
        private AccountItemEntities accountE;
        private DataCallBack dataCallBack;

        public GetAccountItemAsync(AccountDAO accountDAO, DataCallBack dataCallBack) {
            this.accountDAO = accountDAO;
            this.dataCallBack = dataCallBack;
        }

        @Override
        protected Void doInBackground(AccountItemEntities... accountItemEntities) {
            try {
                accountE = accountDAO.getAccount();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(accountE != null){
                dataCallBack.onSuccess(accountE);
            }else{
                dataCallBack.onFail("Not Found Product");
            }
        }
    }
    private class DeleteAllAccountAsync extends AsyncTask<AccountItemEntities, Void, Void> {
        private AccountDAO mDaoAsync;

        public DeleteAllAccountAsync(AccountDAO mDaoAsync) {
            this.mDaoAsync = mDaoAsync;
        }

        @Override
        protected Void doInBackground(AccountItemEntities... accountItemEntities) {
            try {
                mDaoAsync.deleleAllAccount();
            } catch (SQLiteConstraintException e) {

            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }
    }

    private class UpdateCustomerAsyn extends AsyncTask<AccountItemEntities, Void, Void> {
        private AccountDAO mAccountDaoAsync;
        public UpdateCustomerAsyn(AccountDAO mAccountDao) {
            this.mAccountDaoAsync = mAccountDao;
        }
        @Override
        protected Void doInBackground(AccountItemEntities... accountItemEntities) {
            try {
               mAccountDaoAsync.updateAccount(accountItemEntities);
            } catch (SQLiteConstraintException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    public void updateAccount(AccountItemEntities accountItemEntities) {
        UpdateCustomerAsyn updateCustomerAsyn = new UpdateCustomerAsyn(accountDAO);
        updateCustomerAsyn.execute(accountItemEntities);
    }

    public void deleteAllAccount() {
        DeleteAllAccountAsync deleteAsync = new DeleteAllAccountAsync(accountDAO);
        deleteAsync.execute();
    }
    public void addAccountItem(AccountItemEntities accountItemEntities){
        AddAccountItemAsync addAccountItemAsync = new AddAccountItemAsync(accountDAO);
        addAccountItemAsync.execute(accountItemEntities);
    }
    public void getAccountItem(DataCallBack dataCallBack){
        GetAccountItemAsync getAccountItemAsync = new GetAccountItemAsync(accountDAO, dataCallBack);
        getAccountItemAsync.execute();
    }
}
