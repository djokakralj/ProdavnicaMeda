/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.FizickoLice;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleFizickaLica extends AbstractTableModel {

    private List<FizickoLice> lista;
    private List<FizickoLice> svaLista;
    private final String[] kolone = {"ID kupca", "Ime", "Prezime", "JMBG"};

    public ModelTabeleFizickaLica(List<FizickoLice> lista) {
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
        FizickoLice fl = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return fl.getKupac().getIdKupac();
            case 1:
                return fl.getKupac().getIme();
            case 2:
                return fl.getKupac().getPrezime();
            case 3:
                return fl.getJmbg();
            default:
                return "NA";
        }
    }

    public List<FizickoLice> getLista() {
        return lista;
    }

    public void setLista(List<FizickoLice> lista) {
        this.lista = lista;
        this.svaLista = lista;
        fireTableDataChanged();
    }

    public void pretrazi(String imePrezime, String jmbg) {
        List<FizickoLice> filtrirana = svaLista.stream()
                .filter(fl -> (imePrezime == null || imePrezime.isEmpty()
                || (fl.getKupac().getIme() + " " + fl.getKupac().getPrezime()).toLowerCase().contains(imePrezime.toLowerCase())))
                .filter(fl -> (jmbg == null || jmbg.isEmpty() || fl.getJmbg().contains(jmbg)))
                .collect(Collectors.toList());
        this.lista = filtrirana;
        fireTableDataChanged();
    }
}
