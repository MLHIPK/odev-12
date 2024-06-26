package org.odev12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection baglanti = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11678198", "sql11678198", "wVJ6TIBGWB");

            String sorgu = "SELECT * FROM ogrenciler";
            PreparedStatement preparedStatement = baglanti.prepareStatement(sorgu);

            ResultSet sonuclar = preparedStatement.executeQuery();


            while (sonuclar.next()) {
                int ogrenciID = sonuclar.getInt("ogrenciID");
                String ad = sonuclar.getString("ad");
                String soyad = sonuclar.getString("soyad");

                System.out.println("Öğrenci ID: " + ogrenciID + ", Ad: " + ad + ", Soyad: " + soyad);
            }


            sonuclar.close();
            preparedStatement.close();
            baglanti.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
