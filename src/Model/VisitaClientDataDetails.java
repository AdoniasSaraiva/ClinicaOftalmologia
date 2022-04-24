package Model;

import java.util.ArrayList;

public class VisitaClientDataDetails {

    private ArrayList<Visita> visitaList;
    private ArrayList<DataClientVisit> dataClientVisitList;

    public VisitaClientDataDetails() {
    }

    public VisitaClientDataDetails(ArrayList<Visita> visita, ArrayList<DataClientVisit> dataClientVisit) {
        visitaList = visita;
        dataClientVisitList = dataClientVisit;
    }

    public ArrayList<Visita> getVisitaList() {
        return visitaList;
    }

    public ArrayList<DataClientVisit> getDataClientVisitList() {
        return dataClientVisitList;
    }

}
