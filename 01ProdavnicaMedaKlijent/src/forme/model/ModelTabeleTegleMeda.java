/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.TeglaMeda;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleTegleMeda extends AbstractTableModel {

    private List<TeglaMeda> lista;
    private List<TeglaMeda> svaLista;
    private final String[] kolone = {"ID", "Gramaza", "Vrsta tegle", "Vrsta meda", "Cena po gramu", "Cena"};

    public ModelTabeleTegleMeda(List<TeglaMeda> lista) {
        this.lista = lista;
        this.svaLista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TeglaMeda tm = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tm.getIdTeglaMeda();
            case 1:
                return tm.getGramaza();
            case 2:
                return tm.getVrstaTegle();
            case 3:
                return tm.getVrstaMeda();
            case 4:
                return tm.getCenaPoGramu();
            case 5:
                return tm.getCena();
            default:
                return "NA";
        }
    }

    public List<TeglaMeda> getLista() {
        return lista;
    }

    public void setLista(List<TeglaMeda> lista) {
        this.lista = lista;
        this.svaLista = lista;
        fireTableDataChanged();
    }

    public void pretrazi(String vrstaMeda, String vrstaTegle) {
        List<TeglaMeda> filtrirana = svaLista.stream()
                .filter(tm -> (vrstaMeda == null || vrstaMeda.isEmpty() || tm.getVrstaMeda().toLowerCase().contains(vrstaMeda.toLowerCase())))
                .filter(tm -> (vrstaTegle == null || vrstaTegle.isEmpty() || tm.getVrstaTegle().toLowerCase().contains(vrstaTegle.toLowerCase())))
                .collect(Collectors.toList());
        this.lista = filtrirana;
        fireTableDataChanged();
    }
}
