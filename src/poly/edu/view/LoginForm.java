package view;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.SourceVersion;
import poly.edu.model.User;
import poly.edu.repository.DBContext;
import poly.edu.service.impl.UserService;
import poly.edu.utility.ContactHelper;
import poly.edu.utility.DialogHelper;
import poly.edu.view.StudentForm;
import poly.edu.view.RegisterForm;
import poly.edu.view.GradeForm;
import poly.edu.view.SystemForm;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class LoginForm extends javax.swing.JFrame {

    DialogHelper dialogHelper = new DialogHelper();
    ContactHelper contactHelper = new ContactHelper();
    UserService us = new UserService();

    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void loginMethod() {
        String password = new String(txt_password.getPassword());
        String username = txt_username.getText();
        if (txt_username.getText().isEmpty()) {
            jlb_errUser.setText("User không được để trống!");
            txt_username.requestFocus();
            return;
        } else {
            jlb_errUser.setText(" ");
        }
        if (password.isEmpty()) {
            jlb_errPass.setText("Password không được để trống!");
            txt_password.requestFocus();
        } else {
            jlb_errPass.setText(" ");
        }
        if (us.getOne(username) != null) {
            if (us.getOne(username).getPassword().equals(password)) {
//                if (us.getOne(username).getVaitro() == 1) {
//                    dialogHelper.alert(this, "Bạn đang đăng nhập với vai trò giảng viên!");
//                    this.dispose();
//                    new GradeForm().setVisible(true);
//                    return;
//                } else {
//                    dialogHelper.alert(this, "Bạn đang đăng nhập với vai trò đào tạo!");
//                    this.dispose();
//                    new StudentForm().setVisible(true);
//                    return;
//                }
                dialogHelper.alert(this, "Đăng nhập thành công!");
                this.dispose();
                SystemForm systemForm = new SystemForm(us.getOne(username));
                systemForm.setVisible(true);
            } else {
                dialogHelper.error(this, "Mật khẩu không chính xác!");
                txt_password.requestFocus();
            }
        } else {
            dialogHelper.alert(this, "Tên đăng nhập không tồn tại!");
            txt_username.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();
        lbl_title1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btn_signin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_forgot = new javax.swing.JLabel();
        jlb_errUser = new javax.swing.JLabel();
        jlb_errPass = new javax.swing.JLabel();
        lbl_returnSignUp = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        jlb_close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập hệ thống");
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(79, 37, 64));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N

        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("WELCOME TO SIGN IN FORM");

        lbl_title1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title1.setText("Vu Nguyen Huong");
        lbl_title1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_title1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(197, 89, 83));

        txt_username.setBackground(new java.awt.Color(197, 89, 83));
        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setBorder(null);
        txt_username.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });

        txt_password.setBackground(new java.awt.Color(197, 89, 83));
        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setBorder(null);
        txt_password.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        btn_signin.setBackground(new java.awt.Color(197, 89, 83));
        btn_signin.setForeground(new java.awt.Color(255, 255, 255));
        btn_signin.setText("Login");
        btn_signin.setToolTipText("Login");
        btn_signin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_signin.setFocusPainted(false);
        btn_signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signinActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_24px_1.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_password_24px_1.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SIGN IN");

        lbl_forgot.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbl_forgot.setForeground(new java.awt.Color(255, 255, 255));
        lbl_forgot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_forgot.setText("Fogot password ?");
        lbl_forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_forgotMouseClicked(evt);
            }
        });

        jlb_errUser.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jlb_errUser.setForeground(new java.awt.Color(255, 255, 255));
        jlb_errUser.setText(" ");

        jlb_errPass.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jlb_errPass.setForeground(new java.awt.Color(255, 255, 255));
        jlb_errPass.setText(" ");

        lbl_returnSignUp.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbl_returnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        lbl_returnSignUp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_returnSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_key_24px.png"))); // NOI18N
        lbl_returnSignUp.setText("Bạn chưa có tài khoản? Đăng ký ngay");
        lbl_returnSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_returnSignUpMouseClicked(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(197, 89, 83));
        btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel.setText("Cancel");
        btn_cancel.setToolTipText("Cancel");
        btn_cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_cancel.setFocusPainted(false);
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        jlb_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_cancel_20px.png"))); // NOI18N
        jlb_close.setToolTipText("Close");
        jlb_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jlb_close))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_errUser, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jlb_errPass, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btn_signin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbl_forgot, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbl_returnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3))
                    .addComponent(jlb_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1))
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jlb_errUser)))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2))
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jlb_errPass)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_signin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(lbl_forgot)
                .addGap(7, 7, 7)
                .addComponent(lbl_returnSignUp))
        );

        txt_username.getAccessibleContext().setAccessibleName("");
        txt_username.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_title1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_title1MouseClicked
        contactHelper.contact("https://www.facebook.com/VuNguyenHuong.Official");
    }//GEN-LAST:event_lbl_title1MouseClicked

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void lbl_returnSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_returnSignUpMouseClicked
        this.dispose();
        new RegisterForm().setVisible(true);
    }//GEN-LAST:event_lbl_returnSignUpMouseClicked

    private void lbl_forgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_forgotMouseClicked
        if (dialogHelper.question(this, "Oops, bạn quên mật khẩu sao? LH Facebook: Vũ Nguyên Hướng để được hỗ trợ")) {
            contactHelper.contact("https://www.facebook.com/VuNguyenHuong.Official");
        }
    }//GEN-LAST:event_lbl_forgotMouseClicked

    private void btn_signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signinActionPerformed
        loginMethod();
    }//GEN-LAST:event_btn_signinActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginMethod();
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed

    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginMethod();
        }
    }//GEN-LAST:event_txt_usernameKeyPressed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed

    }//GEN-LAST:event_txt_usernameActionPerformed

    private void jlb_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_closeMouseClicked
        if (dialogHelper.question(this, "Bạn có muốn thoát khỏi chương trình ?")) {
            dialogHelper.alert(this, "Thoát thành công!");
            System.exit(0);
        }
    }//GEN-LAST:event_jlb_closeMouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        if(txt_password.getEchoChar() != '\u2022'){
            txt_password.setEchoChar('\u2022');
        }else{
            txt_password.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        if(txt_password.getEchoChar() != '\u2022'){
            txt_password.setEchoChar('\u2022');
        }else{
            txt_password.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_jLabel2MouseReleased

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LoginForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_signin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_close;
    private javax.swing.JLabel jlb_errPass;
    private javax.swing.JLabel jlb_errUser;
    private javax.swing.JLabel lbl_forgot;
    private javax.swing.JLabel lbl_returnSignUp;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_title1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
