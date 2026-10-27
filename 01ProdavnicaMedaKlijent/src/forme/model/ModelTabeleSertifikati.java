/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Sertifikat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleSertifikati extends AbstractTableModel {

    private List<Sertifikat> lista;
    private List<Sertifikat> svaLista;
    private final String[] kolone = {"ID", "Naziv"};

    public ModelTabeleSertifikati(List<Sertifikat> lista) {
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
        Sertifikat s = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIdSertifikat();
            case 1:
                return s.getNaziv();
            default:
                return "NA";
        }
    }

    public List<Sertifikat> getLista() {
        return lista;
    }

    public void setLista(List<Sertifikat> lista) {
        this.lista = lista;
        this.svaLista = lista;
        fireTableDataChanged();
    }

    public void pretrazi(String naziv) {
        List<Sertifikat> filtrirana = svaLista.stream()
                .filter(s -> (naziv == null || naziv.isEmpty() || s.getNaziv().toLowerCase().contains(naziv.toLowerCase())))
                .collect(Collectors.toList());
        this.lista = filtrirana;
        fireTableDataChanged();
    }
}
