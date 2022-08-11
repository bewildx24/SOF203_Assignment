package poly.edu.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import poly.edu.model.User;
import poly.edu.utility.DialogHelper;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class SystemForm extends javax.swing.JFrame {

    DialogHelper dialogHelper = new DialogHelper();

    User user;

    public SystemForm(User u) {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        lbl_hello.setText("Hello, " + u.getUsername() + ". Chúc bạn ngày mới tốt lành!");
        if (u.getVaitro() == 0) {
            lbl_vaitro.setText("Bạn đang đăng nhập với vai trò Đào tạo, vui lòng chọn đúng chức năng ở bên dưới!");
        } else {
            lbl_vaitro.setText("Bạn đang đăng nhập với vai trò Giảng viên, vui lòng chọn đúng chức năng ở bên dưới!");
        }
        user = u;
        clock();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void clock() {
        new Thread() {
            public void run() {
                while (true) {
                    Calendar ca = new GregorianCalendar();
                    int hour = ca.get(Calendar.HOUR);
                    int min = ca.get(Calendar.MINUTE);
                    int sec = ca.get(Calendar.SECOND);
                    int AM_PM = ca.get(Calendar.AM_PM);

                    String day_night;
                    if (AM_PM == 1) {
                        day_night = "PM";
                    } else {
                        day_night = "AM";
                    }
                    lbl_clock.setText(hour + ":" + min + ":" + sec + " " + day_night);
                }
            }
        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_hello = new javax.swing.JLabel();
        lbl_vaitro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_student = new javax.swing.JButton();
        btn_teacher = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        lbl_clock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(79, 37, 64));

        jPanel4.setBackground(new java.awt.Color(79, 37, 64));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WELCOME TO MY PROJECT!");

        lbl_hello.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_hello.setForeground(java.awt.Color.red);
        lbl_hello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_hello.setText("Hello, ...");

        lbl_vaitro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_vaitro.setForeground(new java.awt.Color(255, 255, 102));
        lbl_vaitro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vaitro.setText("Bạn đang đăng nhập với vai trò ...");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("© CoppyRight 2022 Vu Nguyen Huong");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addComponent(lbl_hello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_vaitro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_hello)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_vaitro)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btn_student.setBackground(new java.awt.Color(197, 89, 83));
        btn_student.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_student.setForeground(java.awt.Color.white);
        btn_student.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        btn_student.setText("Giảng viên");
        btn_student.setBorder(null);
        btn_student.setBorderPainted(false);
        btn_student.setFocusPainted(false);
        btn_student.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_student.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_studentActionPerformed(evt);
            }
        });
        jPanel1.add(btn_student);

        btn_teacher.setBackground(new java.awt.Color(197, 89, 83));
        btn_teacher.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_teacher.setForeground(new java.awt.Color(255, 255, 255));
        btn_teacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teacher.png"))); // NOI18N
        btn_teacher.setText("Đào tạo");
        btn_teacher.setBorder(null);
        btn_teacher.setBorderPainted(false);
        btn_teacher.setFocusPainted(false);
        btn_teacher.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_teacher.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_teacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_teacherActionPerformed(evt);
            }
        });
        jPanel1.add(btn_teacher);

        jPanel2.setBackground(new java.awt.Color(79, 37, 64));

        btn_logout.setBackground(new java.awt.Color(197, 89, 83));
        btn_logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_logout_20px.png"))); // NOI18N
        btn_logout.setText("Log Out");
        btn_logout.setBorder(null);
        btn_logout.setBorderPainted(false);
        btn_logout.setFocusPainted(false);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        lbl_clock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_clock.setForeground(new java.awt.Color(255, 255, 255));
        lbl_clock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alarm.png"))); // NOI18N
        lbl_clock.setText("00:00:00 AM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_clock, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_clock, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_studentActionPerformed
        if (user.getVaitro() == 1) {
            dialogHelper.alert(this, "Đăng nhập thành công!");
            this.dispose();
            new GradeForm(user).setVisible(true);
        } else {
            dialogHelper.error(this, "Bạn đang đăng nhập với vai trò đào tạo, vui lòng chọn lại!");
        }
    }//GEN-LAST:event_btn_studentActionPerformed

    private void btn_teacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_teacherActionPerformed
        if (user.getVaitro() == 0) {
            dialogHelper.alert(this, "Đăng nhập thành công!");
            this.dispose();
            new StudentForm(user).setVisible(true);
        } else {
            dialogHelper.error(this, "Bạn đang đăng nhập với vai trò giảng viên, vui lòng chọn lại!");
        }
    }//GEN-LAST:event_btn_teacherActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        if (dialogHelper.question(this, "Bạn có chắc muốn đăng xuất ?")) {
            dialogHelper.alert(this, "Đăng xuất thành công!");
            this.dispose();
            SplashScreen splashScreen = new SplashScreen();
            splashScreen.setVisible(true);
        }
    }//GEN-LAST:event_btn_logoutActionPerformed

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SystemForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_student;
    private javax.swing.JButton btn_teacher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_clock;
    private javax.swing.JLabel lbl_hello;
    private javax.swing.JLabel lbl_vaitro;
    // End of variables declaration//GEN-END:variables
}
