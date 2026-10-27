/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.PravnoLice;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabelePravnaLica extends AbstractTableModel {

    private List<PravnoLice> lista;
    private List<PravnoLice> svaLista;
    private final String[] kolone = {"ID kupca", "Ime", "Prezime", "PIB"};

    public ModelTabelePravnaLica(List<PravnoLice> lista) {
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
        PravnoLice pl = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pl.getKupac().getIdKupac();
            case 1:
                return pl.getKupac().getIme();
            case 2:
                return pl.getKupac().getPrezime();
            case 3:
                return pl.getPib();
            default:
                return "NA";
        }
    }

    public List<PravnoLice> getLista() {
        return lista;
    }

    public void setLista(List<PravnoLice> lista) {
        this.lista = lista;
        this.svaLista = lista;
        fireTableDataChanged();
    }

    public void pretrazi(String imePrezime, String pib) {
        List<PravnoLice> filtrirana = svaLista.stream()
                .filter(pl -> (imePrezime == null || imePrezime.isEmpty()
                || (pl.getKupac().getIme() + " " + pl.getKupac().getPrezime()).toLowerCase().contains(imePrezime.toLowerCase())))
                .filter(pl -> (pib == null || pib.isEmpty() || pl.getPib().contains(pib)))
                .collect(Collectors.toList());
        this.lista = filtrirana;
        fireTableDataChanged();
    }
}
