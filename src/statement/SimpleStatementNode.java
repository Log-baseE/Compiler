package statement;

import java.util.ArrayList;
import java.util.Arrays;

import main.InstructionOffset;
import main.Parser;

import main.Instruction;
import main.ParserException;

public class SimpleStatementNode extends StatementNode {

    @Override
    public ArrayList<InstructionOffset> parse() throws ParserException {
        ArrayList<Instruction> instructions;

        String split[] = getLine().split("(?=[-+*/()<>!]|(?<![<>=!])=)|(?<=[-+*/()]|[<>=!](?!=))");
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(split));
//        System.out.println(tokens);
        instructions = Parser.parseAssignStatement(tokens, getLineNumber());
        ArrayList<InstructionOffset> instructionOffset = new ArrayList<>();
        int i = 0;
        for (Instruction ins : instructions) {
            instructionOffset.add(new InstructionOffset(ins, i++));
        }
        return instructionOffset;
    }

    public SimpleStatementNode(String line, int lineNumber) {
        setLine(line);
        setLineNumber(lineNumber);
    }
}
