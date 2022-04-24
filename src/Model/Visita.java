package Model;
public class Visita {
    private int VisitaId;
    private int ClientId;
    private String DataVisit;
    
    
    public Visita(){}
    public Visita(Client client, String dataVisita){
        ClientId = client.getId();
        DataVisit = dataVisita;
    }
    public Visita(int idVisita, int clientId, String dataVisita){
        VisitaId = idVisita;
        ClientId = clientId;
        DataVisit = dataVisita;
    }
    public Visita(int clientId){
        ClientId = clientId;
    }

    public int getId() {
        return VisitaId;
    }

    public void setId(int Id) {
        this.VisitaId = Id;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int ClientId) {
        this.ClientId = ClientId;
    }

    public String getDataVisit() {
        return DataVisit;
    }

    public void setDataVisit(String DataVisit) {
        this.DataVisit = DataVisit;
    }
}
