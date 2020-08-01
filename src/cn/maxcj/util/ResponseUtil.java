package cn.maxcj.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author maxcj
 */
public class ResponseUtil {

    public static void response(HttpServletResponse response, String message, String redirectPage) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println();
        writer.println("<script type = 'text/javascript'>");
        if (StringUtils.isNotBlank(message)) {
            writer.println("alert('" + message + "');");
        }
        writer.println("window.location = '" + redirectPage + "';");
        writer.println("</script>");
        writer.flush();
        writer.close();
    }

}
