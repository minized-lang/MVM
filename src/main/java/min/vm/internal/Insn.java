package min.vm.internal;

/**
 * MinVM Instruction
 */
public class Insn {
    public OpCode cmd;
    public Object data;

    Insn(OpCode c, Object d) {
        this.cmd = c;
        this.data = d;
    }

    @Override
    public String toString() {
        return "";
    }
}
