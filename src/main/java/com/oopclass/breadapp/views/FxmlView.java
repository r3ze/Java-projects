package com.oopclass.breadapp.views;

import java.util.ResourceBundle;

/**
 * OOP Class 20-21
 *
 * @author Gerald Villaran
 */
public enum FxmlView {

    LOGIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    },PRODUCT {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("product.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/ProdManagement.fxml";
        }
    },HOME{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("home.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Home.fxml";
        }
    }, SALES{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("sales.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/sales.fxml";
        }
    }, ORDERS{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("orders.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/order.fxml";
        }
    };

    public abstract String getTitle();

    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key) {
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
