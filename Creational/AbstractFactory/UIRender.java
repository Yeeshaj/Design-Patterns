package Creational.AbstractFactory;

enum UiComponents {
    WINDOWS, MAC
}

public class UIRender {
    
    public static void main(String[] args) {

        ButtonFactory buttonFactory  = new ButtonFactory(UiComponents.WINDOWS);
       
        Button button = buttonFactory.createButton();
        
        CheckBox checkbox = buttonFactory.createCheckBox();

        button.rendering();
        
        checkbox.rendering();
    }
}

interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

class ButtonFactory implements GUIFactory {

   private UiComponents components;

   ButtonFactory(UiComponents components) {
    this.components = components;
   }
   
   void setUiComponents(UiComponents components) {
    this.components  = components;
   }

    @Override
    public  Button createButton() {
        switch (components ) {
            case WINDOWS: return new WindowsButton();
            case MAC: return new MacButton();
        
            default:
                return null;
        }
        
    }

    @Override
    public  CheckBox createCheckBox() {
        switch (components ) {
            case WINDOWS: return new WindowsCheckBox();
            case MAC: return new MacCheckBox();
        
            default:
                return null;
        }
    }
    
}

abstract class Button {
    abstract void rendering();
}

class WindowsButton extends Button{

    @Override
    void rendering() {
        // TODO Auto-generated method stub
        System.out.println("Rendering Windows Button");
        
    }

}

class MacButton extends Button {
    @Override
    void rendering() {
        // TODO Auto-generated method stub
        System.out.println("Rendering Mac Button");
        
    }
}

abstract class CheckBox {
    abstract void rendering();
}

class WindowsCheckBox extends CheckBox {
    @Override
    void rendering() {
        // TODO Auto-generated method stub
        System.out.println("Rendering Windows Checkbox");
        
    }
}

class MacCheckBox extends CheckBox {
    @Override
    void rendering() {
        // TODO Auto-generated method stub
        System.out.println("Rendering Mac CheckBox");
        
    }
}