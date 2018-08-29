package Util;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Util {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static void main(String[] args) {
        //Util util = new Util();
        //util.enviarEmail("bruno@crossystem.com.br", "testando", "Enviado via Java");
        Random random = new Random();
        System.out.println(random.nextInt(9000));
    }

    public String retornarNumeroAleatorio() {
        Random random = new Random();
        return String.valueOf(random.nextInt(9999));
    }

    public void ziparArquivo(String dirImp, String dirTmp, List<String> filenames, String outFilename) {
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        try {
            // Create the ZIP file
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(dirTmp + "/" + outFilename));
            // Compress the files
            for (int i = 0; i < filenames.size(); i++) {
                FileInputStream in = new FileInputStream(dirImp + "/" + filenames.get(i));
                // Add ZIP entry to output stream.
                out.putNextEntry(new ZipEntry(filenames.get(i)));
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                // Complete the entry
                out.closeEntry();
                in.close();
            }
            // Complete the ZIP file
            out.close();
            out.finish();

        } catch (IOException e) {
        }
    }

    public boolean validarEmail(String pEmail) {

        System.out.println("Metodo de validacao de email");
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher m = p.matcher(pEmail);
        if (m.find()) {
            System.out.println("O email " + pEmail + " e valido");
            return true;
        } else {
            System.out.println("O E-mail " + pEmail + " é inválido");
            return false;
        }
    }

    public void enviarEmail(String pDestinatario, String pAssunto, String pMsg) {
        String msg = "<html>"
                + "<body>"
                + pMsg
                + "</body>"
                + "</html>";

        //        String msg = "Estou aqui!";
        Email from = new Email("disparo.email@missoesnacionais.org.br");
        from.setName("Junta de Missões Nacioanais da CBB - Central de Relacionamento");

        String subject = pAssunto;

        //Email to = new Email("email.brunoribeiro@gmail.com");
        Email to = new Email(pDestinatario);
        Content content = new Content("text/html", msg);

        Mail mail = new Mail(from, subject, to, content);

        //mail.setTemplateId("ac673c1e-6aee-4374-a000-a8b4fb564389");
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            Response response = sg.api(request);
        } catch (IOException ex) {

        }
    }

    public void enviarEmailNovoCadastro(String pEmail, String pChave) {
        String msg = "<html>"
                + "<body>"
                + "<p>"
                + "<a href='https://relacionamento.jmn.org.br/relacionamento/portal/logado/cadastrar_senha.jsf?id=" + pChave + "'>"
                + "<img border='0' src='https://relacionamento.jmn.org.br/relacionamento2/images/novo_cadastro.png' >"
                + "</a>"
                + "<br/>"
                + "<a href='https://relacionamento.jmn.org.br/relacionamento/portal/logado/cadastrar_senha.jsf?id=" + pChave + "'>"
                + "Caso não visualize a imagem, click aqui para Acessar o Portal de Relacionamento:"
                + "</a>"
                + "</p>"
                + ""
                + "</body>"
                + "</html>";

        System.out.println("Estou aqui");

        Email from = new Email("disparo.email@missoesnacionais.org.br");
        from.setName("Junta de Missões Nacioanais da CBB - Central de Relacionamento");

        String subject = "Portal de Relacionamento";

        //Email to = new Email("email.brunoribeiro@gmail.com");
        Email to = new Email(pEmail);
        Content content = new Content("text/html", msg);

        Mail mail = new Mail(from, subject, to, content);

        //mail.setTemplateId("ac673c1e-6aee-4374-a000-a8b4fb564389");
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            Response response = sg.api(request);
        } catch (IOException ex) {

        }
    }

    public static String stringHexa(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }

    public static byte[] gerarHash(String frase, String algoritmo) {
        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.update(frase.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public boolean isValidCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public boolean isValidCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static String initCap(String text) {
        String c = (text != null) ? text.trim() : "";
        String[] words = c.split(" ");
        String result = "";
        for (String w : words) {
            result += (w.length() > 1 ? w.substring(0, 1).toUpperCase(Locale.US) + w.substring(1, w.length()).toLowerCase() : w) + " ";
        }
        return result.trim();
    }

    public String retornarMesExtenso(String pMes) {
        if (pMes == null) {
            return "";
        }
        switch (pMes) {
            case "1":
                return "Janeiro";
            case "2":
                return "Fevereiro";
            case "3":
                return "Março";
            case "4":
                return "Abril";
            case "5":
                return "Maio";
            case "6":
                return "Junho";
            case "7":
                return "Julho";
            case "8":
                return "Agosto";
            case "9":
                return "Setembro";
            case "10":
                return "Outubro";
            case "11":
                return "Novembro";
            case "12":
                return "Dezembro";
            default:
                return "Mês inválido";
        }
    }

    public static String sendPost(String pUrl, String pUrlParametros, String pMetodo)  {
        try {
            URL obj = new URL(pUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(pMetodo);
//            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Content-Type", "application/json;charset=ISO-8859-1");
            //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            con.setDoOutput(true);
            con.setDoInput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(pUrlParametros);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();

            //BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj).openConnection()).getInputStream(), Charset.forName("UTF-8")));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            return response.toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + " - " + pUrlParametros);
            return null;
            //try {
            //    Thread.sleep(5000L);
           // } catch (InterruptedException ex1) {
           //     Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex1);
           // }
            //return sendPost(pUrl, pUrlParametros, pMetodo);
        }
    }

}
