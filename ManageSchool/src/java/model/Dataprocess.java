/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enity.Trainer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kienv
 */
public class Dataprocess {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user = "sa";
            String pass = "123456";
            String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ManageSchool";
            try {
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(Dataprocess.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;

    }
//    public static void main(String[] args) {
//        new Dataprocess().getConnection();
//    }

    public boolean addStaff(String id, String pass, String email, String address, String birthday, String profile) {
        int f = 0;
        String sql = "INSERT INTO tblTrainer VALUES(?,?,?,?,?,?)";
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, birthday);
            ps.setString(6, profile);

            f = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f > 0;
    }

    public boolean addTrainer(String id, String pass, String email, String address, String birthday, String profile) {
        int f = 0;
        String sql = "INSERT INTO tblTrainer VALUES (?,?,?,?,?,?)";
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, birthday);
            ps.setString(6, profile);

            f = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f > 0;
    }

    public ArrayList<Trainer> getTrainer() {
        ArrayList<Trainer> list = new ArrayList<Trainer>();
        String sql = "Select * from tbSong  ";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Trainer s = new Trainer();
                s.setId(rs.getString(1));
                s.setPass(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setAddress(rs.getString(4));
                s.setBrithday(rs.getString(5));
                s.setProfile(rs.getString(6));
                list.add(s);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean addStaffInTopic(String _idTrainer, String[] topicId) {
        Connection conn = getConnection();
        try {
            Statement st = conn.createStatement();
            conn.setAutoCommit(false);
            for (String id : topicId) {
                st.addBatch("INSERT INTO TrainerinTopic VALUES ('" + id + "','" + _idTrainer + "')");
            }
            st.executeBatch();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public ArrayList<Course> getSong() {
        ArrayList<Course> list = new ArrayList<Course>();
        String sql = "Select * from tbSong  ";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Song s = new Song();
                s.setId(rs.getString(1));
                s.setName(rs.getString(2));
                s.setPrice(rs.getFloat(3));
                s.setSampleURL(rs.getString(4));
                s.setFulURL(rs.getString(5));
                s.setIdC(rs.getString(6));
                s.setIdSg(rs.getString(7));
                list.add(s);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
