/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Kupac;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleKupci extends AbstractTableModel {

    private List<Kupac> lista;
    private List<Kupac> svaLista;
    private final String[] kolone = {"ID", "Ime", "Prezime", "Datum rodjenja", "Starost"};
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleKupci(List<Kupac> lista) {
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
        Kupac k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIdKupac();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getDatumRodjenja() == null ? "" : sdf.format(k.getDatumRodjenja());
            case 4:
                return k.getStarost();
            default:
                return "NA";
        }
    }

    public List<Kupac> getLista() {
        return lista;
    }

    public void setLista(List<Kupac> lista) {
        this.lista = lista;
        this.svaLista = lista;
        fireTableDataChanged();
    }

    public void pretrazi(String ime, String prezime) {
        List<Kupac> filtrirana = svaLista.stream()
                .filter(k -> (ime == null || ime.isEmpty() || k.getIme().toLowerCase().contains(ime.toLowerCase())))
                .filter(k -> (prezime == null || prezime.isEmpty() || k.getPrezime().toLowerCase().contains(prezime.toLowerCase())))
                .collect(Collectors.toList());
        this.lista = filtrirana;
        fireTableDataChanged();
    }
}
