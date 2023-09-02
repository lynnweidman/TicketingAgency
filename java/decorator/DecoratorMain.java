package decorator;

public class DecoratorMain {
    public static void main(String args[]) {
        ToolBox basicToolBox = new BasicToolBox(new BuildAToolBox());
        basicToolBox.builderToolboxContents();

        ToolBox biggerToolBox = new BiggerToolBox(new BasicToolBox(new BuildAToolBox()));
        biggerToolBox.builderToolboxContents();
    }
}
