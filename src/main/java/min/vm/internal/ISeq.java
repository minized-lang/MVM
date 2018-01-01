package min.vm.internal;

import java.util.Vector;

public class ISeq extends Vector<Insn> {
    ISeq() {
    }

    public void append(ISeq i) {

    }

    public ISeq silce(long from, long to) {
        return this;
    }

    public OpCode cmdAt(long idx) {
        return null;
    }

    public Object dataAt(long idx) {
        return new Object();
    }

    @Override
    public String toString() {
        return "";
    }
}
