package decorator;

public class BiggerToolBox extends ToolBoxDecorator {

    public BiggerToolBox(ToolBox toolBox) {
        super(toolBox);
    }

    @Override
    public void builderToolboxContents() {
        super.builderToolboxContents();
        System.out.println("Drill and saw");
    }
}
