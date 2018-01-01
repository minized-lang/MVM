package min.vm;

/**
 * MinVM CLI Interface
 */
public class Main {

    /**
     * Main method
     * CLI Usage:
     * java -jar mvm.jar r|run [file] run a program
     * java -jar mvm.jar cat [file1] [file2] contact two ISeq s
     * java -jar mvm.jar s|sym [file] view debug symbols
     * java -jar mvm.jar d|disasm [file] disassembly a EMFile
     * java -jar mvm.jar l|load [file] load a serialized ISeq (maybe with DbgSym)
     * java -jar mvm.jar d|dump [file] serialize ISeq (maybe with DbgSym)
     *
     * Environments
     * MVM_TRACE path to trace program (invoked once each instruction)
     * @param args Command-line arguments
     */
    public void main(String[] args) {

    }
}
