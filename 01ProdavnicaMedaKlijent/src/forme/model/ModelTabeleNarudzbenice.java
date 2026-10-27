/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Narudzbenica;
import domen.TeglaMeda;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleNarudzbenice extends AbstractTableModel {

    private List<Narudzbenica> lista;
    private final String[] kolone = {"ID", "Datum izdavanja", "Ukupan iznos", "Ukupno stavki", "Prodavac", "Kupac"};
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleNarudzbenice(List<Narudzbenica> lista) {
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
        Narudzbenica n = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return n.getIdNarudzbenica();
            case 1:
                return n.getDatumIzdavanja() == null ? "" : sdf.format(n.getDatumIzdavanja());
            case 2:
                return n.getUkupanIznos();
            case 3:
                return n.getUkupnoStavki();
            case 4:
                return n.getProdavac() == null ? "" : n.getProdavac().toString();
            case 5:
                return n.getKupac() == null ? "" : n.getKupac().toString();
            default:
                return "NA";
        }
    }

    public List<Narudzbenica> getLista() {
        return lista;
    }

    public void setLista(List<Narudzbenica> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void pretraziPoTegli(TeglaMeda teglaMeda) {
        if (teglaMeda == null) {
            return;
        }
        List<Narudzbenica> filtrirana = lista.stream()
                .filter(n -> n.getStavke() != null && n.getStavke().stream()
                .anyMatch(s -> s.getTeglaMeda() != null && s.getTeglaMeda().getIdTeglaMeda() == teglaMeda.getIdTeglaMeda()))
                .collect(Collectors.toList());
        this.lista = filtrirana;
        fireTableDataChanged();
    }
}
