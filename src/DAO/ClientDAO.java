package DAO;

import Model.Client;
import View.ConsultarPaciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientDAO {

    static ArrayList<Client> arrayA = new ArrayList();

    public static boolean InsertNewClient(Client a) throws Exception {
        boolean response = false;
        if (ClientExists(a.getTaxnumber())) {
            String sql = "INSERT INTO Client values(null,?,?,?)";

            ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
            Connection connection = connectionSingleton.getConexao();

            try {
                //Connection con = Conexao.AbrirConexao();
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, a.getNome());
                ps.setString(2, a.getTaxnumber());
                ps.setString(3, a.getDtNascimento());

                if (ps.executeUpdate() > 0) {
                    //Conexao.FecharConexao();
                    response = true;

                } else {
                    response = false;
                    throw new Exception("Ocorreu algum erro no cadastro do Cliente:" + a.getNome());
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Está caindo na Exception do Método: InsertNewClient");
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            response = false;
            JOptionPane.showMessageDialog(null, "O cliente já possui registro");
        }
        return response;
    }

    public static ArrayList<Client> GetAllClient() {
        String sql = "SELECT * FROM `Client`\n"
                    + "WHERE\n"
                    + "NameClient IS NOT NULL AND\n"
                    + "Taxnumber IS NOT NULL AND\n"
                    + "DtNascimento IS NOT NULL";
        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
        Connection connection = connectionSingleton.getConexao();
        try {
            //Connection con = Conexao.AbrirConexao();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String nome = rs.getString(2);
                    String Taxnumber = rs.getString(3);
                    String dtNascimento = rs.getString(4);

                    Client r = new Client(id, nome, Taxnumber, dtNascimento);
                    arrayA.add(r);
                }
            }
        } catch (SQLException a) {

            JOptionPane.showMessageDialog(null, a.getMessage());
        }
        return arrayA;
    }

    public static boolean ClientExists(String taxnumber) {
        String sql = "SELECT * FROM Client WHERE Taxnumber LIKE '%" + taxnumber + "%'";
        boolean response = true;

        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
        Connection connection = connectionSingleton.getConexao();

        try {
            //Connection con = Conexao.AbrirConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();

            response = rs != null;
        } catch (SQLException a) {
            //Conexao.FecharConexao();
            JOptionPane.showMessageDialog(null, "Caiu no método: ClientExists - 0");
            JOptionPane.showMessageDialog(null, a.getMessage());
        } catch (Exception a) {
            //Conexao.FecharConexao();
            JOptionPane.showMessageDialog(null, "Caiu no método: ClientExists - 1");
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
        return response;
    }

    public static Client GetClientById(int idClient) {
        String sql = "SELECT * FROM Client WHERE IdClient ='" + idClient + "'";
        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstancy();
        Connection connection = connectionSingleton.getConexao();
        try {
            //Connection con = Conexao.AbrirConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String Taxnumber = rs.getString(3);
                String dtNascimento = rs.getString(4);

                Client client = new Client(id, nome, Taxnumber, dtNascimento);
                //Conexao.FecharConexao();
                return client;
            }
        } catch (SQLException a) {
            //Conexao.FecharConexao();
            JOptionPane.showMessageDialog(null, "Está caindo na Exception do Método: GetClientById - 0");
            JOptionPane.showMessageDialog(null, a.getMessage());
        } catch (Exception a) {
            //Conexao.FecharConexao();
            JOptionPane.showMessageDialog(null, "Está caindo na Exception do Método: GetClientById - 1");
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
        return null;
    }
}
