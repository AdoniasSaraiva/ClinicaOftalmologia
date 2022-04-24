package Model;

public class Client {

    private int ClientId;
    private String Nome;
    private String Taxnumber;
    private String DtNascimento;

    public Client() {
    }

    public Client(int id) {
        ClientId = id;
    }

    public Client(String nome, String taxnumber, String dtNascimento) {
        Nome = nome;
        Taxnumber = taxnumber;
        DtNascimento = dtNascimento;
    }

    public Client(int clientId, String nome, String taxnumber, String dtNascimento) {
        ClientId = clientId;
        Nome = nome;
        Taxnumber = taxnumber;
        DtNascimento = dtNascimento;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return ClientId;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.ClientId = Id;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Taxnumber
     */
    public String getTaxnumber() {
        return Taxnumber;
    }

    /**
     * @param Taxnumber the Taxnumber to set
     */
    public void setTaxnumber(String Taxnumber) {
        this.Taxnumber = Taxnumber;
    }

    /**
     * @return the DtNascimento
     */
    public String getDtNascimento() {
        return DtNascimento;
    }

    /**
     * @param DtNascimento the DtNascimento to set
     */
    public void setDtNascimento(String DtNascimento) {
        this.DtNascimento = DtNascimento;
    }
}
