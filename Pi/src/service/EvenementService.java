/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entities.Evenement;
import util.DataSource;



/**
 *
 * @author Guideinfo
 */
public class EvenementService {

    static DataSource ds =DataSource.getInstance(); 
    
    
    public static void insererEvenement (Evenement e)
    {
    String req="INSERT INTO evenement (nom,ref_etab,date_debut,date_fin,description,image) VALUES(?,?,?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setString(1,e.getNom()) ; 
            ste.setString(2,e.getRefEtab()) ; 
            ste.setString(3,e.getDateDebut());
            ste.setString(4,e.getDateFin());
            ste.setString(5,e.getDescription());
            ste.setString(6,e.getIimage());
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
     
    public static void updateEvenement (Evenement e )
    {
    String req="UPDATE evenement SET nom=?,ref_etab=?,date_debut=?,date_fin=?,description=?,image=? WHERE ref =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setString(1,e.getNom()) ; 
            ste.setString(2,e.getRefEtab()) ; 
            ste.setString(3,e.getDateDebut());
            ste.setString(4,e.getDateFin());
            ste.setString(5,e.getDescription());
            ste.setString(6,e.getIimage());
            ste.setInt(7,e.getRef()) ;
            System.out.println(e.getRef());
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
     public static void DeletEvenement (Evenement e)
    {
    String req="DELETE  from evenement where  ref =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,e.getRef()) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
      }
     public static void DeletEvenementByID (int e)
    {
    String req="DELETE  from evenement where  ref =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,e) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
      }
    public static List<Evenement> selectEvenement ()
    {
        List<Evenement> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT *  FROM evenement ";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new Evenement(
                                    result.getInt("ref"),
                                    result.getString("nom"),
                                    result.getString("ref_etab"),
                                    result.getString("date_debut"),
                                    result.getString("date_fin"),
                                    result.getString("description"),
                                    result.getString("image")
            )); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      }
     
    
    
    
    
}
