package com.example.flowermobile.rooms.management;

import android.app.Application;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import com.example.flowermobile.rooms.OrderItemEntities;
import com.example.flowermobile.rooms.dao.OrderDAO;
import com.example.flowermobile.rooms.database.FlowerDatabase;

import java.util.List;

public class OrderItemManagement {
    private OrderDAO orderDAO;
    private Application application;
    public OrderItemManagement(Application application) {
        this.application = application;
        FlowerDatabase flowerDatabase = FlowerDatabase.getDatabase(application);
        orderDAO = flowerDatabase.orderDAO();
    }

    public interface DataCallBack{
      void onSuccess(List<OrderItemEntities> list);
      void onFail(String message);
    }
    private class AddOrderItemAsync extends AsyncTask<OrderItemEntities, Void, Void> {
        private OrderDAO orderDAO;
        @Override
        protected Void doInBackground(OrderItemEntities... orderItemEntities) {
            orderDAO.insertOrderItem(orderItemEntities);
            return null;
        }

        public AddOrderItemAsync(OrderDAO orderDAO) {
            this.orderDAO = orderDAO;
        }
    }
    private class GetOrderItemAsync extends AsyncTask<List<OrderItemEntities>, Void, Void> {
        private OrderDAO orderDAO;
        private List<OrderItemEntities> listItemEntities;
        private DataCallBack dataCallBack;

        public GetOrderItemAsync(OrderDAO orderDAO, DataCallBack dataCallBack) {
            this.orderDAO = orderDAO;
            this.dataCallBack = dataCallBack;
        }

        @Override
        protected Void doInBackground(List<OrderItemEntities>... lists) {
           try {
               listItemEntities = orderDAO.getListOrderItem();

           }catch (Exception e){

           }
           return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(listItemEntities != null){
                dataCallBack.onSuccess(listItemEntities);
            }else{
                dataCallBack.onFail("Not Found Product");
            }
        }
    }
     public void addOrderItem(OrderItemEntities orderItemEntities){
        AddOrderItemAsync addOrderItemAsync = new AddOrderItemAsync(orderDAO);
        addOrderItemAsync.execute(orderItemEntities);
     }
     public void getOrderItem(DataCallBack dataCallBack){
        GetOrderItemAsync getOrderItemAsync = new GetOrderItemAsync(orderDAO, dataCallBack);
        getOrderItemAsync.execute();
     }
    public void deleteOrderItem(OrderItemEntities orderItem) {
        DeleteOrderItemAsyn deleteOrderItemAsyn = new DeleteOrderItemAsyn(orderDAO);
        deleteOrderItemAsyn.execute(orderItem);
    }
    public void updateOrder(OrderItemEntities orderItemEntities) {
        UpdateOrderAsyn updateOrderAsyn = new UpdateOrderAsyn(orderDAO);
        updateOrderAsyn.execute(orderItemEntities);
    }
    private class DeleteOrderItemAsyn extends AsyncTask<OrderItemEntities, Void, Void> {
        private OrderDAO orderDAO;

        public DeleteOrderItemAsyn(OrderDAO orderDAO) {
            this.orderDAO = orderDAO;
        }

        @Override
        protected Void doInBackground(OrderItemEntities... orderItem) {
            orderDAO.deleteOrderItem(orderItem);
            return null;
        }
    }

    private class UpdateOrderAsyn extends AsyncTask<OrderItemEntities, Void, Void> {
        private OrderDAO mOrderDAO;

        public UpdateOrderAsyn(OrderDAO mOrderDAO) {
            this.mOrderDAO = mOrderDAO;
        }

        @Override
        protected Void doInBackground(OrderItemEntities... orderItemEntities) {
            try {
                mOrderDAO.updateOrder(orderItemEntities);
            } catch (SQLiteConstraintException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    private class DeleteAllOrderAsync extends AsyncTask<OrderItemEntities, Void, Void> {
        private OrderDAO mDaoAsync;

        public DeleteAllOrderAsync(OrderDAO mDaoAsync) {
            this.mDaoAsync = mDaoAsync;
        }

        @Override
        protected Void doInBackground(OrderItemEntities... orderItemEntities) {
            try {
                mDaoAsync.deleleAllOrder();
            } catch (SQLiteConstraintException e) {

            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
    public void deleteAllOrder() {
        DeleteAllOrderAsync deleteAsync = new DeleteAllOrderAsync(orderDAO);
        deleteAsync.execute();
    }
}
