/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Database.DBMS;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Madushanka
 */
public class paysheet extends javax.swing.JFrame {

    /**
     * Creates new form paysheet
     */
    public paysheet() {
        initComponents();
    }
    public paysheet(String a,String b,String c) {
        try{
        initComponents();
        String c_id = a;
        String sf_date = b;
        String pg = c;
        JREmptyDataSource dataSource = new JREmptyDataSource();
        HashMap<String,Object> map = new HashMap<>();
        map.put("Parameter1", c_id);
        ResultSet rs = DBMS.search("SELECT * FROM customer WHERE `id`='"+c_id+"'");
        while (rs.next()) {            
            String name = rs.getString("name");
            String route = rs.getString("route");
            map.put("Parameter2", name);
            map.put("Parameter58", route);
        }
        ResultSet rs1 = DBMS.search("SELECT * FROM payment WHERE `c_id`='"+c_id+"' AND `f_date`='"+sf_date+"'");
        while (rs1.next()) {            
            String nweight = rs1.getString("nweight");
            map.put("Parameter3", nweight);
            String nper_kg = rs1.getString("nprice");
            map.put("Parameter4", nper_kg);
            String ntotal = rs1.getString("ntotal");
            map.put("Parameter55", ntotal);
            String aweight = rs1.getString("aweight");
            map.put("Parameter52", aweight);
            String aper_kg = rs1.getString("aprice");
            map.put("Parameter53", aper_kg);
            String atotal = rs1.getString("atotal");
            map.put("Parameter57", atotal);
            
            String chemi = rs1.getString("chemicle");
            map.put("Parameter36", chemi);
            String otc = rs1.getString("otherC");
            map.put("Parameter37", otc);
            String dificit_money = rs1.getString("dificit_money");
            map.put("Parameter38", dificit_money);
            String pohora  = rs1.getString("pohora");
            map.put("Parameter39", pohora);
            String advance  = rs1.getString("advance");
            map.put("Parameter40", advance);
            String tea_p  = rs1.getString("tea_pw");
            map.put("Parameter41", tea_p);
            String transport_fee  = rs1.getString("trans");
            map.put("Parameter42", transport_fee);
            String grocery  = rs1.getString("grocery");
            map.put("Parameter43", grocery);
            String s_value  = rs1.getString("tprice");
            map.put("Parameter44", s_value);
            String stamp = rs1.getString("dmpa");
            map.put("Parameter45", stamp);
            String lp  = rs1.getString("loan_p");
            String pa  = rs1.getString("poli_a");
            double d_dif_mny = Double.valueOf(dificit_money);
            double d_pohora = Double.valueOf(pohora);
            double d_ad = Double.valueOf(advance);
            double d_tp = Double.valueOf(tea_p);
            double d_trns = Double.valueOf(transport_fee);
            double d_gcry = Double.valueOf(grocery);
            double d_chem = Double.valueOf(chemi);
            double d_oth = Double.valueOf(otc);
            double d_lp = Double.valueOf(lp);
            double d_pa = Double.valueOf(pa);
            double all_dif = d_dif_mny+d_pohora+d_ad+d_tp+d_trns+d_gcry+d_chem+d_oth+d_lp+d_pa;
            String s_all_dif = String.valueOf(all_dif);
            map.put("Parameter46", s_all_dif);
            String balance  = rs1.getString("balance");
            double d_bal = Double.valueOf(balance);
            if(d_bal<0){
                double d_l_bal = d_bal*-1;
                String s_d_bal = String.valueOf(d_l_bal);
                String s_bal = "0";
                map.put("Parameter47", s_bal);
                map.put("Parameter48", s_d_bal);
            }else{
                String s_b = "0";
                map.put("Parameter47", balance);
                map.put("Parameter48", s_b);
            }
            String f_date = rs1.getString("f_date");
            String t_date = rs1.getString("t_date");
            
            String gy = f_date.substring(0, 4);
            String x = "-";
            String gym = gy.concat(x);
                char cdate3 = f_date.charAt(5);
                char cdate4 = f_date.charAt(6);
                String sdate4 = String.valueOf(cdate3);
                String sdate5 = String.valueOf(cdate4);
                String sdate6 = sdate4+sdate5;
                String mo = "";
                ResultSet rs11 = DBMS.search("SELECT * FROM month WHERE `id`='"+sdate6+"'");
                if(rs11.next()){
                    mo = rs11.getString("month");
                }
                String m = gym.concat(mo);
                map.put("Parameter51", m);
            
            
            ResultSet rs2 = DBMS.search("SELECT * FROM stock WHERE `c_id`='"+c_id+"' AND  `date` BETWEEN '"+f_date+"' AND '"+t_date+"'");
            String s_wei = "0";
                    map.put("Parameter5",s_wei);
                    map.put("Parameter6",s_wei);
                    map.put("Parameter7",s_wei);
                    map.put("Parameter8",s_wei);
                    map.put("Parameter9",s_wei);
                    map.put("Parameter10",s_wei);
                    map.put("Parameter11",s_wei);
                    map.put("Parameter12",s_wei);
                    map.put("Parameter13",s_wei);
                    map.put("Parameter14",s_wei);
                    map.put("Parameter15",s_wei);
                    map.put("Parameter16",s_wei);
                    map.put("Parameter17",s_wei);
                    map.put("Parameter18",s_wei);
                    map.put("Parameter19",s_wei);
                    map.put("Parameter20",s_wei);
                    map.put("Parameter21",s_wei);
                    map.put("Parameter22",s_wei);
                    map.put("Parameter23",s_wei);
                    map.put("Parameter24",s_wei);
                    map.put("Parameter25",s_wei);
                    map.put("Parameter26",s_wei);
                    map.put("Parameter27",s_wei);
                    map.put("Parameter28",s_wei);
                    map.put("Parameter29",s_wei);
                    map.put("Parameter30",s_wei);
                    map.put("Parameter31",s_wei);
                    map.put("Parameter32",s_wei);
                    map.put("Parameter33",s_wei);
                    map.put("Parameter34",s_wei);
                    map.put("Parameter35",s_wei);
            while (rs2.next()) {                
                String date  = rs2.getString("date");
                String weig  = rs2.getString("weight");
                char cdate1 = date.charAt(8);
                char cdate2 = date.charAt(9);
                String sdate1 = String.valueOf(cdate1);
                String sdate2 = String.valueOf(cdate2);
                String sdate3 = sdate1+sdate2;
                 
                if(sdate3.equals("01")){
                    map.replace("Parameter5", weig);
                }else if(sdate3.equals("02")){
                    map.replace("Parameter6",weig);
                }else if(sdate3.equals("03")){
                    map.replace("Parameter7",weig);
                }else if(sdate3.equals("04")){
                    map.replace("Parameter8",weig);
                }else if(sdate3.equals("05")){
                    map.replace("Parameter9",weig);
                }else if(sdate3.equals("06")){
                    map.replace("Parameter10",weig);
                }else if(sdate3.equals("07")){
                    map.replace("Parameter11",weig);
                }else if(sdate3.equals("08")){
                    map.replace("Parameter12",weig);
                }else if(sdate3.equals("09")){
                    map.replace("Parameter13",weig);
                }else if(sdate3.equals("10")){
                    map.replace("Parameter14",weig);
                }else if(sdate3.equals("11")){
                    map.replace("Parameter15",weig);
                }else if(sdate3.equals("12")){
                    map.replace("Parameter16",weig);
                }else if(sdate3.equals("13")){
                    map.replace("Parameter17",weig);
                }else if(sdate3.equals("14")){
                    map.replace("Parameter18",weig);
                }else if(sdate3.equals("15")){
                    map.replace("Parameter19",weig);
                }else if(sdate3.equals("16")){
                    map.replace("Parameter20",weig);
                }else if (sdate3.equals("17")){
                    map.replace("Parameter21",weig);
                }else if(sdate3.equals("18")){
                    map.replace("Parameter22",weig);
                }else if(sdate3.equals("19")){
                    map.replace("Parameter23",weig);
                }else if(sdate3.equals("20")){
                    map.replace("Parameter24",weig);
                }else if(sdate3.equals("21")){
                    map.replace("Parameter25",weig);
                }else if(sdate3.equals("22")){
                    map.replace("Parameter26",weig);
                }else if(sdate3.equals("23")){
                    map.replace("Parameter27",weig);
                }else if(sdate3.equals("24")){
                    map.replace("Parameter28",weig);
                }else if(sdate3.equals("25")){
                    map.replace("Parameter29",weig);
                }else if (sdate3.equals("26")){
                    map.replace("Parameter30",weig);
                }else if(sdate3.equals("27")){
                    map.replace("Parameter31",weig);
                }else if(sdate3.equals("28")){
                    map.replace("Parameter32",weig);
                }else if(sdate3.equals("29")){
                    map.replace("Parameter33",weig);
                }else if(sdate3.equals("30")){
                    map.replace("Parameter34",weig);
                }else if(sdate3.equals("31")){
                    map.replace("Parameter35",weig);
                }
            
            }
            
            String report = null;
            if(pg.equals("A")){
                String r_lp  = rs1.getString("loan_p");
                map.put("Parameter59", r_lp);
                String r_pr  = rs1.getString("poli_r");
                map.put("Parameter60", r_pr);
                String r_pa  = rs1.getString("poli_a");
                map.put("Parameter61", r_pa);
                Double loan_all = d_lp+d_pa;
                String s_loan = String.valueOf(loan_all);
                map.put("Parameter62", s_loan);
                String r_ab  = rs1.getString("loan_ab");
                map.put("Parameter63", r_ab);
                String stampr = rs1.getString("dmpr");
                map.put("Parameter64", stampr);
                
            report = "/reports/tea(m)2.jasper";
            }else{
                String stampr = rs1.getString("dmpr");
                map.put("Parameter59", stampr);
            report = "/reports/tea(m).jasper";
            }
        InputStream is = getClass().getResourceAsStream(report);

        JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(is,map ,dataSource );
        } catch (Exception ex) {
            System.out.println(ex);
        }
           JasperPrintManager.printReport(print, false);
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(paysheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paysheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paysheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paysheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new paysheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
