package pro.krasikov.sample.mBean;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 26.07.2014.
 */
public class BenchmarkController implements BenchmarkControllerMBean {

    private boolean enabled;

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
