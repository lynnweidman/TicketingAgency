package decorator;

public class ToolBoxDecorator implements ToolBox {
    protected ToolBox toolBox;

    public ToolBoxDecorator(ToolBox toolBox) {
        this.toolBox = toolBox;
    }

    @Override
    public void builderToolboxContents() {
        this.toolBox.builderToolboxContents();
    }
}
