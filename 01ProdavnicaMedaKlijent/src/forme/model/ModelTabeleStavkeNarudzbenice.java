/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.StavkaNarudzbenice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleStavkeNarudzbenice extends AbstractTableModel {

    private List<StavkaNarudzbenice> lista;
    private final String[] kolone = {"RB", "Tegla meda", "Kolicina", "Cena stavke"};

    public ModelTabeleStavkeNarudzbenice(List<StavkaNarudzbenice> lista) {
        this.lista = lista;
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
        StavkaNarudzbenice sn = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return sn.getTeglaMeda() == null ? "" : sn.getTeglaMeda().toString();
            case 2:
                return sn.getKolicina();
            case 3:
                return sn.getCenaStavke();
            default:
                return "NA";
        }
    }

    public List<StavkaNarudzbenice> getLista() {
        return lista;
    }

    public void setLista(List<StavkaNarudzbenice> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void dodajStavku(StavkaNarudzbenice sn) {
        lista.add(sn);
        fireTableDataChanged();
    }

    public void obrisiStavku(StavkaNarudzbenice sn) {
        lista.remove(sn);
        fireTableDataChanged();
    }
}
