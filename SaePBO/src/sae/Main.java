/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sae;
import saetask.Pesan;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ovasae
 */
public class Main {
    
    private static int total=0;

    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        Integer pilih=0;

        ArrayList<Pesan> listPesan=new ArrayList();
        do{
            System.out.println("Bintang Bucks Coffee");
            System.out.println("1. Pemesanan");
            System.out.println("2. Pembayaran");
            System.out.println("3. Keluar");
            System.out.println("---------------------");
            System.out.print("Pilihan Anda :");
            pilih = sc.nextInt();

            if(pilih == 1){
                //Masukan Order
                listPesan = beli(listPesan);
            }else if(pilih==2){
                //Tampilkan Order
                listPesan = bayar(listPesan);
                if(total > 0){
                    System.out.println("Bayar : ");
                    Integer amount = sc.nextInt();
                    if (amount < total){
                        do {
                            System.out.println("Uang anda kurang...");
                            System.out.println("Bayar : ");
                            amount = sc.nextInt();
                        }while (amount < total);

                        System.out.println("Kembalian : "+(amount-total));
                    }else{
                        System.out.println("Kembalian : "+(amount-total));
                    }
                    listPesan.clear();
                }
            }
        }while (pilih != 3);
    }

    private static ArrayList<Pesan> beli(ArrayList<Pesan> listPesan) {
        String nama,gula;
        Integer harga,qty;
        Scanner sc=new Scanner(System.in);

        System.out.println("Nama : ");
        nama = sc.nextLine();
        if (!nama.equalsIgnoreCase("americano") && !nama.equalsIgnoreCase("latte") && !nama.equalsIgnoreCase("arabika")) {
            do {
                System.out.println("Nama Pesanan Tidak Sesuai...");
                System.out.println("Nama : ");
                nama = sc.nextLine();
            } while(!nama.equalsIgnoreCase("americano") && !nama.equalsIgnoreCase("latte") &&!nama.equalsIgnoreCase("arabika"));
        }
        System.out.println("Gula :");
        gula = sc.nextLine();
        System.out.println("Harga : ");
        harga = sc.nextInt();
        System.out.println("Qty : ");
        qty = sc.nextInt();
        if(qty <= 0) {
            do{
                System.out.println("Qty minimal 1 ");
                System.out.println("Qty : ");
                qty = sc.nextInt();
            }while (qty <= 0);
        }

        listPesan.add(new Pesan(nama,gula,harga,qty));

        return listPesan;
    }

    private static ArrayList<Pesan> bayar(ArrayList<Pesan> listPesan) {
        Scanner sc=new Scanner(System.in);
        total = 0;
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-10s | %-5s | %-7s | %-7s | %-7s |",
                "Nama",
                "Gula",
                "Harga",
                "Qty",
                "Jumlah" );
        System.out.println();
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < listPesan.size(); i++) {
            System.out.printf("| %-7s  | %-5s  | %-7s  | %-7s  | %-7s |",
                    listPesan.get(i).getNama(),
                    listPesan.get(i).getGula(),
                    listPesan.get(i).getHarga(),
                    listPesan.get(i).getQty(),
                    (listPesan.get(i).getHarga()*listPesan.get(i).getQty()));
            total = total+(listPesan.get(i).getHarga()*listPesan.get(i).getQty());
            System.out.println();
            System.out.println("----------------------------------------------------");

        }
        System.out.println("Total : "+total);

        if(total==0){
            System.out.println("Tekan Enter...");
            sc.nextLine();
        }

        return  listPesan;
    }
    
}
