package quest.flo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger log = LogManager.getLogger(Calculator.class);
    private float result = 0;

    private enum Slot {
        One, Two, Three
    }

    private final float[] memory = {0, 0, 0};

    public Calculator(float start) {
        this.result = start;
        log.info("New Calculator started with " + this.result + " as starting point!");
    }

    public Calculator() {
        log.info("New Calculator started with " + this.result + " as starting point!");
    }

    public Calculator add(float num) {
        this.result += num;
        return this;
    }

    public Calculator sub(float num) {
        this.result -= num;
        return this;
    }

    public Calculator mul(float num) {
        this.result *= num;
        return this;
    }

    public Calculator div(float num) throws Exception {
        if (num == 0) {
            log.error("Cannot divide by zero: not doing any division.");

            throw new Exception("Tried dividing by zero!");
        }

        this.result /= num;
        return this;
    }

    public float mod(float num) {
        return this.result % num;
    }

    public Calculator exp(float num) {
        this.result = (float) Math.pow(this.result, num);
        return this;
    }

    public Calculator nrt(float num) {
        double xPre = Math.random() % 10;
        double eps = 0.001F;
        double delX = 2147483647;
        double xK = 0.0F;

        while (delX > eps) {
            xK = (((num - 1.0) * xPre + this.result / Math.pow(xPre, num - 1)) / num);
            delX = Math.abs(xK - xPre);
            xPre = xK;
        }

        this.result = (float) xK;

        return this;
    }

    public float result() {
        return this.result;
    }

    public float recall(Slot slot) throws Exception {
        switch (slot) {
            case Three -> {
                return this.memory[2];
            }
            case Two -> {
                return this.memory[1];
            }
            case One -> {
                return this.memory[0];
            }
            default -> {
                log.error("Tried accessing non-existent memory-slot!");

                throw new Exception("Tried accessing non-existent memory-slot!");
            }
        }
    }

    public void remember(Slot slot, float memory) {
        switch (slot) {
            case One -> this.memory[0] = memory;
            case Two -> this.memory[1] = memory;
            case Three -> this.memory[2] = memory;
        }
    }
}
