package com.example.linebot.web;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private String aa;
   // public static void main(String[] args) throws Exception {
    public void database(String lat){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //-----------------
            // 接続
            //-----------------
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", // "jdbc:postgresql://[場所(Domain)]:[ポート番号]/[DB名]"
                    "postgres", // ログインロール
                    "postgres"); // パスワード
            statement = connection.createStatement();

            //-----------------
            // SQLの発行
            //-----------------
            //ユーザー情報のテーブル
         //   resultSet = statement.executeQuery("SELECT * FROM test_table");

            //-----------------
            //insertは下二文
            System.out.println(lat);
            aa ="'"+lat+"'";

            String sql2 ="insert into test_table(lat)values(aa)";

            statement.executeUpdate(sql2);

            // 値の取得
            //-----------------
            // フィールド一覧を取得
//            List<String> fields = new ArrayList<String>();
//            ResultSetMetaData rsmd = resultSet.getMetaData();
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                fields.add(rsmd.getColumnName(i));
//            }
//
//            //結果の出力
//            int rowCount = 0;
//            while (resultSet.next()) {
//                rowCount++;
//
//                System.out.println("---------------------------------------------------");
//                System.out.println("--- Rows:" + rowCount);
//                System.out.println("---------------------------------------------------");
//
//                //値は、「resultSet.getString(<フィールド名>)」で取得する。
//                for (String field : fields) {
//                    System.out.println(field + ":" + resultSet.getString(field));
//                }
//            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //接続を切断する
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
