package Validation;

import org.antlr.runtime.tree.Tree;

import java.util.HashMap;

public abstract class Validator {

    public abstract void validate(Tree tree, HashMap<String, Function> functions) throws Exception;

    protected PreCompileValidator parent;

    public void setParent(PreCompileValidator parent) {
        this.parent = parent;
    }

    protected void printError(String message, Tree node){
        VPrinter.getInstance().printError(message, this.parent.getFilepath(), node.getLine(), node.getCharPositionInLine());
        this.parent.incrementErrorCount();
    }
}
