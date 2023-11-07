import java.util.Date;

public class Logger {
    private StringBuilder sb;

    public Logger() {
        this.sb = new StringBuilder();
    }

    public void log(String message) {
        sb.append(new Date()).append(" ").append(message).append("\n");
    }

    public String getLog() {
        return sb.toString();
    }
}
