/*
   Copyright 2020 Donavie Ordonez, Dennis Tye, Kenneth Doan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import java.util.*;

public class SendEmail {
public static void send(String toEmail, String msg) {
    final String username = "[REDACTED]";
    final String password = "[REDACTED]";

    String destEmail = toEmail.length() == 0 ? "" : toEmail;

    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true");

    Session session = Session.getInstance(prop,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            }
    );

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(destEmail));
        message.setSubject("Enneagram Quiz Results");
        message.setText("Here are the results of your enneagram quiz:\n\n" + msg
        			  + "\n\n\n\n===============================================\n"
        			  + "If you have not requested for these results, please ignore this email and block this address."); 

        Transport.send(message);

    } catch (MessagingException e) {
        e.printStackTrace();
    }
}
}