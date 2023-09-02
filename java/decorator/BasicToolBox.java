package decorator;

public class BasicToolBox extends ToolBoxDecorator{
    public BasicToolBox(ToolBox toolBox) {
        super(toolBox);
    }

    @Override
    public void builderToolboxContents() {
        super.builderToolboxContents();
        System.out.println("Hammer, screwdriver, wrench");
    }
}
