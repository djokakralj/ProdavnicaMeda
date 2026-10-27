/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Prodavac;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleProdavci extends AbstractTableModel {

    private List<Prodavac> lista;
    private List<Prodavac> svaLista;
    private final String[] kolone = {"ID", "Ime", "Prezime", "Korisnicko ime"};

    public ModelTabeleProdavci(List<Prodavac> lista) {
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
        Prodavac p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getIdProdavac();
            case 1:
                return p.getIme();
            case 2:
                return p.getPrezime();
            case 3:
                return p.getKorisnickoIme();
            default:
                return "NA";
        }
    }

    public List<Prodavac> getLista() {
        return lista;
    }

    public void setLista(List<Prodavac> lista) {
        this.lista = lista;
        this.svaLista = lista;
        fireTableDataChanged();
    }

    public void pretrazi(String ime, String prezime) {
        List<Prodavac> filtrirana = svaLista.stream()
                .filter(p -> (ime == null || ime.isEmpty() || p.getIme().toLowerCase().contains(ime.toLowerCase())))
                .filter(p -> (prezime == null || prezime.isEmpty() || p.getPrezime().toLowerCase().contains(prezime.toLowerCase())))
                .collect(Collectors.toList());
        this.lista = filtrirana;
        fireTableDataChanged();
    }
}
