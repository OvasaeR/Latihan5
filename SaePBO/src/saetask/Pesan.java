/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saetask;

/**
 *
 * @author ovasae
 */
public class Pesan {

    String nama;
    String gula;
    Integer harga;
    Integer qty;

    public Pesan(String nama, String gula, Integer harga, Integer qty) {
        this.nama = nama;
        this.gula = gula;
        this.harga = harga;
        this.qty = qty;
    }

    public String getNama() {
        return nama;
    }

    public String getGula() {
        return gula;
    }

    public Integer getHarga() {
        return harga;
    }

    public Integer getQty() {
        return qty;
    }

}
