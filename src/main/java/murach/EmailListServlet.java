package murach;

import java.io.IOException;

import javax.mail.MessagingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailListServlet
        extends HttpServlet {


    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        String action =
                request.getParameter("action");


        if (action == null) {

            action = "join";
        }


        String url = "/index.jsp";


        if (action.equals("join")) {

            url = "/index.jsp";
        }


        else if (action.equals("add")) {


            // Lấy dữ liệu từ form

            String firstName =
                    request.getParameter(
                            "firstName"
                    );


            String lastName =
                    request.getParameter(
                            "lastName"
                    );


            String email =
                    request.getParameter(
                            "email"
                    );


            // Tạo User

            User user =
                    new User(
                            firstName,
                            lastName,
                            email
                    );


            try {


                // Lưu vào database

                UserDB.insert(user);


                request.setAttribute(
                        "user",
                        user
                );


                // Thông tin email

                // Gmail của bạn - nơi nhận dữ liệu
                String to = "hoanghoan717273@gmail.com";


                String from = "hoanghoan717273@gmail.com";

                String subject = "Có người đăng ký từ website";

                String body =
                        "Có một người vừa gửi thông tin từ website.\n\n"
                                + "Email: " + email + "\n"
                                + "First Name: " + firstName + "\n"
                                + "Last Name: " + lastName + "\n\n"
                                + "Thông tin được gửi từ Chapter 14 Mail.";

                boolean isBodyHTML = false;


                // Gửi email

                try {

                    MailUtilLocal.sendMail(
                            to,
                            from,
                            subject,
                            body,
                            isBodyHTML
                    );

                }


                catch (MessagingException e) {


                    String errorMessage =
                            "ERROR: Unable to send email.<br>"
                                    + "Check the Tomcat logs for details.<br>"
                                    + "You may need to configure an SMTP server "
                                    + "as described in Chapter 14.<br>"
                                    + "ERROR MESSAGE: "
                                    + e.getMessage();


                    request.setAttribute(
                            "errorMessage",
                            errorMessage
                    );


                    this.log(
                            "Unable to send email.\n"
                                    + "TO: "
                                    + email
                                    + "\n"
                                    + "FROM: "
                                    + from
                                    + "\n"
                                    + "SUBJECT: "
                                    + subject
                                    + "\n\n"
                                    + body
                                    + "\n",
                            e
                    );
                }


                url = "/thanks.jsp";


            }


            catch (Exception e) {


                request.setAttribute(
                        "errorMessage",
                        "ERROR: Unable to save the user.<br>"
                                + e.getMessage()
                );


                this.log(
                        "Unable to save user.",
                        e
                );


                url = "/error.jsp";
            }
        }


        getServletContext()
                .getRequestDispatcher(url)
                .forward(
                        request,
                        response
                );
    }
}