package poly.edu.view;

import poly.edu.utility.ContactHelper;
import view.LoginForm;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class SplashScreen extends javax.swing.JFrame {

    ContactHelper contactHelper = new ContactHelper();

    public SplashScreen() {
        initComponents();
        setLocationRelativeTo(null);
        loadDing();
    }

    private void loadDing() {
        new Thread() {
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        sleep(30);
                        jlb_percent.setText("Loading " + i + "%");
                        loadingbar.setValue(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (i == 100) {
                        closeWhenDone();
                    }
                }
            }
        }.start();
    }

    private void closeWhenDone() {
        new LoginForm().setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlb_percent = new javax.swing.JLabel();
        loadingbar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlb_contactEmail = new javax.swing.JLabel();
        jlb_contactInsta = new javax.swing.JLabel();
        jlb_contactFB = new javax.swing.JLabel();
        jlb_contactGithub = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(563, 302));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("© CoppyRight 2022 Vu Nguyen Huong");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 272, 579, -1));

        jlb_percent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlb_percent.setForeground(new java.awt.Color(255, 255, 255));
        jlb_percent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_percent.setText("Loading 99%");
        jPanel1.add(jlb_percent, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 245, 579, -1));

        loadingbar.setBackground(new java.awt.Color(255, 255, 255));
        loadingbar.setForeground(new java.awt.Color(197, 89, 83));
        loadingbar.setBorderPainted(false);
        jPanel1.add(loadingbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 211, 579, 27));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system_bgr.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 13, 239, 191));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 13, -1, 191));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THANKS FOR COMMING!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 13, 299, 33));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome to my Project!");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 53, 299, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact with me:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 76, -1, -1));

        jlb_contactEmail.setForeground(new java.awt.Color(255, 255, 255));
        jlb_contactEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_gmail_logo_20px.png"))); // NOI18N
        jlb_contactEmail.setText("Email: huongvnph27229@fpt.edu.vn");
        jPanel1.add(jlb_contactEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 99, 299, -1));

        jlb_contactInsta.setForeground(new java.awt.Color(255, 255, 255));
        jlb_contactInsta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_instagram_20px.png"))); // NOI18N
        jlb_contactInsta.setText("Instagram: vunguyenhuong.official");
        jlb_contactInsta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_contactInstaMouseClicked(evt);
            }
        });
        jPanel1.add(jlb_contactInsta, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 126, 299, -1));

        jlb_contactFB.setForeground(new java.awt.Color(255, 255, 255));
        jlb_contactFB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_facebook_20px.png"))); // NOI18N
        jlb_contactFB.setText("Facebook: Vũ Nguyên Hướng");
        jlb_contactFB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_contactFBMouseClicked(evt);
            }
        });
        jPanel1.add(jlb_contactFB, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 153, 299, -1));

        jlb_contactGithub.setForeground(new java.awt.Color(255, 255, 255));
        jlb_contactGithub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_github_20px.png"))); // NOI18N
        jlb_contactGithub.setText("Github: Huong0510");
        jlb_contactGithub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_contactGithubMouseClicked(evt);
            }
        });
        jPanel1.add(jlb_contactGithub, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 180, 299, -1));

        jLabel10.setBackground(new java.awt.Color(0, 204, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgr.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlb_contactInstaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_contactInstaMouseClicked
        contactHelper.contact("https://www.instagram.com/vunguyenhuong.official/");
    }//GEN-LAST:event_jlb_contactInstaMouseClicked

    private void jlb_contactFBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_contactFBMouseClicked
        contactHelper.contact("https://www.facebook.com/VuNguyenHuong.Official");
    }//GEN-LAST:event_jlb_contactFBMouseClicked

    private void jlb_contactGithubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_contactGithubMouseClicked
        contactHelper.contact("https://github.com/VuHuong0510");
    }//GEN-LAST:event_jlb_contactGithubMouseClicked

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SplashScreen().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlb_contactEmail;
    private javax.swing.JLabel jlb_contactFB;
    private javax.swing.JLabel jlb_contactGithub;
    private javax.swing.JLabel jlb_contactInsta;
    private javax.swing.JLabel jlb_percent;
    private javax.swing.JProgressBar loadingbar;
    // End of variables declaration//GEN-END:variables
}
