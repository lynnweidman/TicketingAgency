package decorator;

public class BuildAToolBox implements ToolBox {

    @Override
    public void builderToolboxContents() {
        System.out.println("Tool box for builders");
    }
}
