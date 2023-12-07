package quest.flo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Info");
        log.warn("Warn");
        log.error("Error");
        log.fatal("Fatal");

        try {
            Calculator calc = new Calculator();
            calc.add(5);
            calc.sub(10);
            calc.mul(3);
            calc.div(5);
            calc.div(-2);
            calc.exp(2);
            calc.nrt(2);
            System.out.println(calc.result());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Calculator calc = new Calculator();
            calc.add(5).sub(10).mul(3).div(5).div(-2).exp(2).nrt(2);
            System.out.println(calc.result());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}