/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enity.Topics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.Dataprocess.getConnection;

/**
 *
 * @author kienv
 */
public class TrainerTopic {
    public ArrayList<Topics> getTopics()
    {
        ArrayList<Topics> list = new ArrayList<Topics>();
        String sql="Select *from tblTopic";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
             while (rs.next()) {
                Topics t = new Topics();
                t.setId(rs.getString(1));
                t.setName(rs.getString(2));
                list.add(t);
             }
             rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(TrainerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    
}
