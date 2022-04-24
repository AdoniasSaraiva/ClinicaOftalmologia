package DAO;

import Model.DataClientVisit;
import Model.Visita;
import Model.VisitaClientDataDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DataClientVisitDAO {

    public static boolean InsertNewDataClientVisit(DataClientVisit dataClientVisit) {
        String sql = "INSERT INTO DataClientVisit VALUES (null, ?,?,?)";

        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
        Connection connection = connectionSingleton.getConexao();

        try {
            //Connection con = Conexao.AbrirConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, dataClientVisit.getVisitaId());
            ps.setInt(2, dataClientVisit.getEye());
            ps.setInt(3, dataClientVisit.getVision());

            if (ps.executeUpdate() < 0) {
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no cadastro da Visita");
            } else {
                //Conexao.FecharConexao();
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Caiu na Exception do método:InsertNewDataClientVisit");
            JOptionPane.showMessageDialog(null, e.getMessage());
            //Conexao.FecharConexao();
        }
        return false;
    }

    public static int GetLastDataByVisitId(int visitId) {
        int lastVisitByClientId = 0;
        String sql = "SELECT VisitClientId FROM `DataClientVisit` WHERE VisitClientId ='" + visitId + "' ORDER BY 1 DESC LIMIT 1";

        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
        Connection connection = connectionSingleton.getConexao();

        try {
            //Connection con = Conexao.AbrirConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    lastVisitByClientId = rs.getInt(1);
                    return lastVisitByClientId;
                }
            }
            //Conexao.FecharConexao();
        } catch (SQLException a) {
            JOptionPane.showMessageDialog(null, a.getMessage());
            JOptionPane.showMessageDialog(null, "Caiu na Exception do método:GetLastDataByVisitId");
        }
        return lastVisitByClientId;
    }

    public static VisitaClientDataDetails GetAllVisitByClientId(int clientId) {
        VisitaClientDataDetails visitaClientDataDetails = new VisitaClientDataDetails();
        Visita visita;
        DataClientVisit dataClientVisit;
        ArrayList<Visita> visitaList = new ArrayList<Visita>();
        ArrayList<DataClientVisit> dataClientVisitList = new ArrayList<DataClientVisit>();
        String sql = "SELECT\n"
                + "	v.VisitaId AS VisitaId,\n"
                + "	v.DataVisit AS DataVisita,\n"
                + "	dt.Eye AS DadosOlho,\n"
                + "	dt.Vision AS DadosVisao\n"
                + "	FROM Visita v\n"
                + "	inner join DataClientVisit dt on (dt.VisitClientId = v.VisitaId)\n"
                + "		WHERE \n"
                + "			v.ClientId = ? AND\n"
                + "			dt.Eye IS NOT NULL AND\n"
                + "			dt.Vision IS NOT NULL \n"
                + "		ORDER BY v.VisitaId";

        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
        Connection connection = connectionSingleton.getConexao();

        try {
            //Connection con = Conexao.AbrirConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int visitaId = rs.getInt(1);
                    String dataVisita = rs.getString(2);
                    int dadosOlho = rs.getInt(3);
                    int dadasVisao = rs.getInt(4);

                    visita = new Visita(visitaId, clientId, dataVisita);
                    dataClientVisit = new DataClientVisit(visitaId, dadosOlho, dadasVisao);

                    visitaList.add(visita);
                    dataClientVisitList.add(dataClientVisit);
                }

                visitaClientDataDetails = new VisitaClientDataDetails(visitaList, dataClientVisitList);
            }
            //Conexao.FecharConexao();
        } catch (SQLException a) {
            JOptionPane.showMessageDialog(null, "Caiu na Exception do método:GetAllVisitByClientId");
            JOptionPane.showMessageDialog(null, a.getMessage());
            //Conexao.FecharConexao();
        }
        return visitaClientDataDetails;
    }
}
