package Model;

public class DataClientVisit {

    private int DataClientVisitId;
    private int VisitaId;
    private int Eye;
    private int Vision;

    public DataClientVisit() {
    }

    public DataClientVisit(int dataClientVisitId, int visita, int eye, int vision) {
        DataClientVisitId = dataClientVisitId;
        VisitaId = visita;
        Eye = eye;
        Vision = vision;
    }

    public DataClientVisit(int visita, int eye, int vision) {
        VisitaId = visita;
        Eye = eye;
        Vision = vision;
    }

    public DataClientVisit(int eye, int vision) {
        Eye = eye;
        Vision = vision;
    }

    /**
     * @return the DataClientVisitId
     */
    public int getDataClientVisitId() {
        return DataClientVisitId;
    }

    /**
     * @param DataClientVisitId the DataClientVisitId to set
     */
    public void setDataClientVisitId(int DataClientVisitId) {
        this.DataClientVisitId = DataClientVisitId;
    }

    /**
     * @return the VisitaId
     */
    public int getVisitaId() {
        return VisitaId;
    }

    /**
     * @param VisitaId the VisitaId to set
     */
    public void setVisitaId(int VisitaId) {
        this.VisitaId = VisitaId;
    }

    /**
     * @return the Eye
     */
    public int getEye() {
        return Eye;
    }

    /**
     * @param Eye the Eye to set
     */
    public void setEye(int Eye) {
        this.Eye = Eye;
    }

    /**
     * @return the Vision
     */
    public int getVision() {
        return Vision;
    }

    /**
     * @param Vision the Vision to set
     */
    public void setVision(int Vision) {
        this.Vision = Vision;
    }
}
