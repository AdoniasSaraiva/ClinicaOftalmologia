package DAO;

import Model.DataClientVisit;
import Model.Visita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VisitaDAO {

    static ArrayList<Visita> arrayA = new ArrayList();

    public static boolean InsertNewVisit(Visita visita, DataClientVisit dataClientVisit) {
        int lastVisitIdByClientId = 0;
        boolean responseFromInsertNewVisit = false;
        boolean responseFromInsertNewDataClient = false;
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yy");
        String dataVisita = dtf2.format(LocalDateTime.now());

        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
        Connection connection = connectionSingleton.getConexao();

        String sql = "INSERT INTO Visita values(null,?,?)";
        try {
            //Connection con = Conexao.AbrirConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, visita.getClientId());
            ps.setString(2, dataVisita);
            int response = ps.executeUpdate();

            if (response < 0) {

                throw new Exception("Ocorreu algum erro no cadastro da Visita");

            } else {

                //Conexao.FecharConexao();
                lastVisitIdByClientId = GetLastVisitByClientId(visita.getClientId());
                dataClientVisit.setVisitaId(lastVisitIdByClientId);
                responseFromInsertNewVisit = true;
                responseFromInsertNewDataClient = DataClientVisitDAO.InsertNewDataClientVisit(dataClientVisit);

                if (responseFromInsertNewVisit == responseFromInsertNewDataClient) {
                    return true;
                }
            }

        } catch (SQLException e) {
            //Conexao.FecharConexao();
            JOptionPane.showMessageDialog(null, "Caiu na Exception do método:InsertNewVisit");
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception ex) {
            //Conexao.FecharConexao();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public static int GetLastVisitByClientId(int clientId) {
        int lastVisitByClientId = 0;
        String sql = "SELECT VisitaId FROM `Visita` WHERE ClientId = ? ORDER BY 1 DESC LIMIT 1";

        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
        Connection connection = connectionSingleton.getConexao();

        try {
            //Connection con = Conexao.AbrirConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    lastVisitByClientId = rs.getInt(1);
                }
            }
            //Conexao.FecharConexao();
        } catch (SQLException a) {
            JOptionPane.showMessageDialog(null, "Caiu na Exception do método:GetLastVisitByClientId");
            JOptionPane.showMessageDialog(null, a.getMessage());
            //Conexao.FecharConexao();
        }
        return lastVisitByClientId;
    }

    public static int GetCountAllVisitByClientId(int clientId) {
        int aux = 0;
        String sql = "SELECT count(*) FROM `Visita` WHERE ClientId ='" + clientId + "'";
        
        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
        Connection connection = connectionSingleton.getConexao();
        
        try {
            //Connection con = Conexao.AbrirConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                aux = rs.getInt(1);
            }
        } catch (SQLException a) {
            //Conexao.FecharConexao();
            JOptionPane.showMessageDialog(null, "Caiu na Exception do método:GetCountAllVisitByClientId");
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
        //Conexao.FecharConexao();
        return aux;
    }

}
